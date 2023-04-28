package com.jrtp.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Plan {
	
	@Column(name = "PLAN_ID")
	@Id
	@GeneratedValue
	private Integer planId;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_STATUS")
	private String activeSw;
	
	@Column(name = "PLAN_START_DATE")
	private String planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private String planEndDate;
	
	@Column(name = "CREATED_AT" , updatable = false)
	@CreationTimestamp
	private LocalDate createdAt;
	
	@Column(name = "UPDATED_AT" , insertable = false)
	@UpdateTimestamp
	private LocalDate updatedAt;
	
	@Column(name = "CREATED_BY")
	private String CreatedBy;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;


}
