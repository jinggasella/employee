package com.rfa.employee.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "enterprise_org_structure")
public class EnterpriseOrgStructure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String ESID;
	private String ESName;
	private String ESSubcoID;
	
	private String parent;
	
	@Embedded 
	private CreationSpecification creationSpecification;

}
