package org.teckArk.responsePOJO.createEmployee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedEmployee {
	@JsonProperty(value = "name")
	public String name;
	
	@JsonProperty(value = "salary")
	public Integer salary;
	
	@JsonProperty(value = "age")
	public Integer age;
	
	@JsonProperty(value = "id")
	public int id;
}
