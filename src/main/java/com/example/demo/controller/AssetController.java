package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Asset;
import com.example.demo.model.Employee;
import com.example.demo.service.AssetService;
import com.example.demo.service.EmployeeService;

@RestController
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	private EmployeeService empService;
	
	@RequestMapping("/employees/{id}/assets")
	public List<Asset> getAllAsset(@PathVariable int id){
		
		return assetService.getAllAsset(id);
	}
	
	@RequestMapping("/employees/{empId}/assets/{id}")
	public Asset getAsset(@PathVariable int id) {
		return assetService.getAsset(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees/{empId}/assets/")
	public void addAsset(@RequestBody Asset asset, @PathVariable int empId) {
		asset.setEmp(new Employee(empId,"",""));
		assetService.addAsset(asset);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{empId}/assets/{id}")
	public void updateAsset(@RequestBody Asset asset, @PathVariable int empId, @PathVariable int id) {
		asset.setEmp(new Employee(empId,"",""));
		//asset.setEmp(empService.getEmp(empId));
		assetService.updateAsset(id,asset);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{empId}/assets/{id}")
	public void deleteAsset(@PathVariable int id) {
		assetService.deleteAsset(id);
	}
}
