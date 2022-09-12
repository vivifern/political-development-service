package com.example.demo.service.impl;

import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.Objects;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.DevelopmentRepository;
import com.example.demo.exception.PoliticalException;
import com.example.demo.model.Development;
import com.example.demo.model.Developments;
import com.example.demo.service.DevelopmentService;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

	private final String URI_FIND_LEADER = "http://leaders-service/leader/findleaderbyid";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DevelopmentRepository repository;
	
	@Override
	public String addDevelopmentWork(Development development) throws PoliticalException {
		String confirmationString = "Development Work Added";
		URIBuilder uriBuilder;
		try {
			uriBuilder = new URIBuilder(URI_FIND_LEADER);
			uriBuilder.addParameter("leaderid", String.valueOf(development.getLeaderId()));
			ResponseEntity<Long> result = restTemplate.getForEntity(uriBuilder.toString(), Long.class);
			if(Objects.isNull(result) || Long.valueOf(result.getBody()) < 1 )
				throw new PoliticalException("Leader with details - " + development.getLeaderId() + " does not exist");
			else {
				if(!development.equals(repository.save(development)))
					confirmationString = "Development Work could not be Added";
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return confirmationString;
	}

	@Override
	public Developments findByLeaderId(Long leaderId) {
		Comparator<Development> comparator = Comparator.comparing(development -> development.getActivityYear());
		return new Developments(repository.findByLeaderId(leaderId)
				.stream().sorted(comparator.reversed()).toList());
	}

}
