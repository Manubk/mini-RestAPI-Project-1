package com.jrtp.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jrtp.Entity.Plan;

@Service
public interface IPlanService {
	public Map<Integer,String> getAllCatogery();
	public List<Plan> getAllPlans();
	public boolean save(Plan plan);
	public Plan getPlanById(Integer id);
	public boolean deleteById(Integer id);
	public boolean changeStatus(Integer id, String val);
}
