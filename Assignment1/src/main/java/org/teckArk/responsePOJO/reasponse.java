package org.teckArk.responsePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class reasponse extends BaseApiResponse{
//we are collecting value of single employee object
	 @JsonProperty(value = "data")
	 public Employee employee;
	 
	
}
