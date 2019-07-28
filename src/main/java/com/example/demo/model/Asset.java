package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int asset_id;
	private String asset_name;
	@Column(nullable=false,unique=true)
	private String model_num;
	
	@ManyToOne
	private Employee emp;
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Asset() {
		
	}
	
	public Asset(int asset_id, String asset_name, String model_num, int empId) {
		super();
		this.asset_id = asset_id;
		this.asset_name = asset_name;
		this.model_num = model_num;
		this.emp = new Employee(empId,"","");
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getModel_num() {
		return model_num;
	}
	public void setModel_num(String model_num) {
		this.model_num = model_num;
	}

}
