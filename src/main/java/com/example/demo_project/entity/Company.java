package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@IdClass(value = OrgCompanyId.class)
public class Company {
                                              //Ω∆¶X•D¡‰
	@Id
	@Column(name = "org_id")
	private String orgId;

	@Id
	@Column(name = "company_id")
	private String companyId;

	@Column(name = "company_name")
	private String company_name;
	

	public Company() {
		
	}

	public Company(String orgId, String companyId, String company_name) {
		this.orgId = orgId;
		this.companyId = companyId;
		this.company_name = company_name;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

}
