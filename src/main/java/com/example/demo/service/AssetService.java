package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Asset;
import com.example.demo.model.Employee;
import com.example.demo.repository.AssetRepo;
import com.example.demo.repository.EmployeeRepo;

@Service
public class AssetService {

	@Autowired
	private AssetRepo assetRepo;
	
	public List<Asset> getAllAsset(int emp_id){
		//return employees;
		List<Asset> asset = new ArrayList<>();
		assetRepo.findByEmpId(emp_id)
		.forEach(asset::add);
		return asset;
	}
	
	public Asset getAsset(int id) {
		//return employees.stream().filter(t -> t.getEmp_id()==id).findFirst().get();
		return assetRepo.findById(id).orElse(null);
	}

	public void addAsset(Asset asset) {
		//employees.add(emp);
		assetRepo.save(asset);
	}

	public void updateAsset(int id, Asset asset) {
		/*
		for(int i=0;i<employees.size();i++) {
			Employee e= employees.get(i);
			if(e.getEmp_id()==id) {
				employees.set(i, emp);
				return;
			}
		}*/
		Asset a = assetRepo.findById(id).orElse(new Asset());
		a.setAsset_id(id);
		a.setAsset_name(asset.getAsset_name());
		a.setModel_num(asset.getModel_num());
		assetRepo.save(a);
	}

	public void deleteAsset(int id) {
		assetRepo.deleteById(id);
	}
}
