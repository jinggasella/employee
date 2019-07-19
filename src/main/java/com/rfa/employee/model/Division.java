package com.rfa.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "division")
public class Division {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = "Division ID (Primary Key)")
	private Long id;
	
	@ApiModelProperty(value = "Division Name", 
			dataType = "String",
			required =  true)
	private String name;
	
	public Division() {
		
	}
	public Division(Long id, String name ) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
