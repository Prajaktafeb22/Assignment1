package org.teckArk.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	//we are collecting value of employee in collection or list
	@JsonProperty(value = "employee_age")
	public String employee_age;
	
	@JsonProperty(value = "employee_name")
	public String employee_name;
	
	@JsonProperty(value = "employee_salary")
	public String employee_salary;
	
	@JsonProperty(value = "id")
	public String id;
	
	@JsonProperty(value = "profile_image")
	public String profile_image;
}
