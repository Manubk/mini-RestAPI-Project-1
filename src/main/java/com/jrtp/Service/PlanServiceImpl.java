package com.jrtp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrtp.Entity.Plan;
import com.jrtp.Entity.PlanCategory;
import com.jrtp.Repository.PlanCategoryRepo;
import com.jrtp.Repository.PlanRepository;

@Service
public class PlanServiceImpl implements IPlanService {
	
	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private PlanCategoryRepo planCatogeryRepo;

	@Override
	public Map<Integer, String> getAllCatogery() {
		List<PlanCategory> planCategorerys = planCatogeryRepo.findAll();

		Map<Integer, String> categorerys = new HashMap<>();

		if (!planCategorerys.isEmpty()) {

			for (PlanCategory planCategory : planCategorerys)
				categorerys.put(planCategory.getCategoryId(), planCategory.getCategoryName());

			return categorerys;
		}

		return null;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> plans = planRepo.findAll();
		 return plans;
	}

	@Override
	public boolean save(Plan plan) {
		Plan plan1 = planRepo.save(plan);
		return plan1.getPlanId()!=null;
	}

	@Override
	public Plan getPlanById(Integer id) {
		Optional<Plan> option = planRepo.findById(id);
		
		if(!option.isEmpty())
			return option.get();
		
		return null;
		
	}

	@Override
	public boolean deleteById(Integer id) {
		
		try {
			planRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean changeStatus(Integer id, String val) {
		Optional<Plan> option = planRepo.findById(id);
		
		if(option.isPresent()) {
			Plan plan = option.get();
			plan.setActiveSw(val);
			planRepo.save(plan);
			return true;
		}		
		return false;
	}

	
	
}
