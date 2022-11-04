package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.OrgCompanyId;
import com.example.demo_project.repository.CompanyDao;
import com.example.demo_project.service.ifs.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	public Company findById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
		Optional<Company> compantOp = companyDao.findById(orgCompanyId);
		/* 方法1
		if(compantOp.isPresent()) {
//			Company com = compantOp.get();
//			return com;
			return compantOp.get();     //返傳Company
		}
		return new Company();
		*/
		//=======方法2=========
		return compantOp.orElse(new Company());
	}

	@Override
	public Company updateById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
		Optional<Company> compantOp = companyDao.findById(orgCompanyId);
		//update name
		if(compantOp.isPresent()) {
			Company com = compantOp.get();
			com.setCompany_name("A02");                //更改mysql的name
			Company newCom = companyDao.save(com);     //saveAndFlush   Flush刷新(避免延遲)
			return newCom;
		}
		return new Company();
	}

	//新增資料
	@Override
	public Company saveCompany() {                           //jpa不提供update語法，如果要的話需先find
		Company com = new Company("DDD","D00","COMD");
		return companyDao.save(com);
	}

}
