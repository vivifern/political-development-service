package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PoliticalException;
import com.example.demo.model.Development;
import com.example.demo.service.DevelopmentService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

	@Autowired
	public DevelopmentService developmentService;
	
	@PostMapping(path = "/adddevelopment")
	public ResponseEntity<?> addDevelopment(@Valid @RequestBody Development development) throws PoliticalException {
		return ResponseEntity.ok(developmentService.addDevelopmentWork(development));
	}
	
	@GetMapping(path = "/getalldevelopments")
	public ResponseEntity<?> getAllDevelopmentTasks(@RequestParam String leaderid){
		return ResponseEntity.ok(developmentService.findByLeaderId(Long.valueOf(leaderid)));
	}
}
