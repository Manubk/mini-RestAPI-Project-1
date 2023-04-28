package com.jrtp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrtp.Entity.Plan;
import com.jrtp.Service.PlanServiceImpl;

@RestController
public class PlanController {
	
	@Autowired
	private PlanServiceImpl planService;
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String msg = "";
		
		msg = planService.save(plan)?"Plan saved Sucessfully":"unable to save plan";
		
	    return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<String> getPlans(){
		return new ResponseEntity<String>("hi there" ,HttpStatus.OK);
	}
}
