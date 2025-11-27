package com.klu;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String job_name;
    private String company_name;
    private String skills_required;
    private String job_type;
    private String description;

    private LocalDate last_date_to_apply;
    private String location;

    private LocalDate created_at = LocalDate.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getSkills_required() {
		return skills_required;
	}

	public void setSkills_required(String skills_required) {
		this.skills_required = skills_required;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getLast_date_to_apply() {
		return last_date_to_apply;
	}

	public void setLast_date_to_apply(LocalDate last_date_to_apply) {
		this.last_date_to_apply = last_date_to_apply;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", job_name=" + job_name + ", company_name=" + company_name + ", skills_required="
				+ skills_required + ", job_type=" + job_type + ", description=" + description + ", last_date_to_apply="
				+ last_date_to_apply + ", location=" + location + ", created_at=" + created_at + "]";
	}

	
}
