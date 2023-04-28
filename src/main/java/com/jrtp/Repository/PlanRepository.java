package com.jrtp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp.Entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
