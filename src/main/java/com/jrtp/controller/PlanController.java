package com.jrtp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrtp.Entity.Plan;
import com.jrtp.Entity.PlanCategory;
import com.jrtp.Service.PlanServiceImpl;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
public class PlanController {

	@Autowired
	private PlanServiceImpl planService;

	@GetMapping("/catogerys")
	public ResponseEntity<Map<Integer, String>> getAllCatogerys() {

		Map<Integer, String> mapCaptogery = planService.getAllCatogery();
		return new ResponseEntity<Map<Integer, String>>(mapCaptogery, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String msg = "";

		msg = planService.save(plan) ? "Plan saved Sucessfully" : "unable to save plan";

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	}

	@GetMapping("/plans")
	public ResponseEntity<String> getPlans() {
		return new ResponseEntity<String>("hi there", HttpStatus.OK);
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		
		return new ResponseEntity<Plan>(plan,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		String msg = "";
		msg = planService.deleteById(planId)?"Deleted Sucessfully":"No Record Found";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
    @PutMapping("/plan/{planId}/{planStatus}")
    public ResponseEntity<String> changeStatus(@PathVariable Integer planId , @PathVariable String planStatus){
    	
    	String msg = "";
    	
    	msg = planService.changeStatus(planId, planStatus)?"SucessFull":"Failur";
    	
    	return new ResponseEntity<String>(msg,HttpStatus.OK);
    	
    }
}
