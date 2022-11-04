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
		/* ��k1
		if(compantOp.isPresent()) {
//			Company com = compantOp.get();
//			return com;
			return compantOp.get();     //���Company
		}
		return new Company();
		*/
		//=======��k2=========
		return compantOp.orElse(new Company());
	}

	@Override
	public Company updateById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
		Optional<Company> compantOp = companyDao.findById(orgCompanyId);
		//update name
		if(compantOp.isPresent()) {
			Company com = compantOp.get();
			com.setCompany_name("A02");                //���mysql��name
			Company newCom = companyDao.save(com);     //saveAndFlush   Flush��s(�קK����)
			return newCom;
		}
		return new Company();
	}

	//�s�W���
	@Override
	public Company saveCompany() {                           //jpa������update�y�k�A�p�G�n���ܻݥ�find
		Company com = new Company("DDD","D00","COMD");
		return companyDao.save(com);
	}

}
