package com.jrtp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrtp.Entity.Plan;
import com.jrtp.Service.IPlanService;
import com.jrtp.Service.PlanServiceImpl;
import com.jrtp.constants.AppConstants;
import com.jrtp.properties.AppMessages;

@RestController
public class PlanController {

	private IPlanService planService;
	
	private Map<String, String> massages ;
	
	public PlanController(IPlanService planService,AppMessages messages) {
		this.planService = planService;
		this.massages = messages.getMessages();
	}

	@GetMapping("/catogerys")
	public ResponseEntity<Map<Integer, String>> getAllCatogerys() {
		
		Map<Integer, String> mapCaptogery = planService.getAllCatogery();
		return new ResponseEntity<Map<Integer, String>>(mapCaptogery, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String msg = AppConstants.EMPTY_STR;
		msg = planService.save(plan) ? massages.get(AppConstants.PLAN_SAVE_SUCESS_MSG) : massages.get(AppConstants.PLAN_SAVE_UNSUCESS_MSG);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED); 

	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getPlans() {
		List<Plan> plans = planService.getAllPlans();
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(plan,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		String msg = AppConstants.EMPTY_STR;
		msg = planService.deleteById(planId)?massages.get(AppConstants.PLAN_DELETE_SUCESS):massages.get(AppConstants.PLAN_DELETE_UNSUCESS);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
    @PutMapping("/plan/{planId}/{planStatus}")
    public ResponseEntity<String> changeStatus(@PathVariable Integer planId , @PathVariable String planStatus){
    	String msg = AppConstants.EMPTY_STR;
    	msg = planService.changeStatus(planId, planStatus)?massages.get(AppConstants.PLAN_STATUS_ACTIVATED):massages.get(AppConstants.PLAN_STATUS_DEACTIVATED);
    	return new ResponseEntity<String>(msg,HttpStatus.OK);
    	
    }
}
