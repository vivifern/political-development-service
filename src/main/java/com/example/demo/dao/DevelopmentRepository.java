package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Development;

public interface DevelopmentRepository extends CrudRepository<Development, Long>{
	
	public List<Development> findByLeaderId(Long leaderId);
	
}
