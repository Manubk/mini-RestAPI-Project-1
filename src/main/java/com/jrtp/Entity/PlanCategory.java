package com.jrtp.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

@Entity
public class PlanCategory {
	
	@Column(name = "CATEGORY_ID")
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String  categoryName;
	
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

	public PlanCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanCategory(Integer categoryId, String categoryName, LocalDate createdAt, LocalDate updatedAt,
			String createdBy, String updatedBy) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		CreatedBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "PlanCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", CreatedBy=" + CreatedBy + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
