package org.teckArk.responsePOJO.createEmployee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEmployeeResponse {
	@JsonProperty(value = "status")
	public String statusResponse;
	
	@JsonProperty(value = "data")
	public CreatedEmployee dataResponse;
	
	@JsonProperty(value = "message")
	public String message;

}
