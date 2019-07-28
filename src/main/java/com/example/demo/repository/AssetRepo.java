package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Asset;
import com.example.demo.model.Employee;

public interface AssetRepo extends CrudRepository<Asset,Integer>{

	public List<Asset> findByEmpId(int emp_id);
}
