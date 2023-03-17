package org.teckArk.responsePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetEmployeeResp extends BaseApiResponse{
	
	 
	
	 @JsonProperty(value = "data")
	 public List<Employee> employeelist;
	 
	 
	
	
}
