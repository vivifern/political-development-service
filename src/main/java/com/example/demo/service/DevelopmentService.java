package com.example.demo.service;

import com.example.demo.exception.PoliticalException;
import com.example.demo.model.Development;
import com.example.demo.model.Developments;

public interface DevelopmentService {

	public String addDevelopmentWork(Development development) throws PoliticalException;
	
	public Developments findByLeaderId(Long leaderId);
}
