package org.teckArk.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteEmployeeResponse extends BaseApiResponse{

	 @JsonProperty(value = "data")
	 public String data;
	 
	 @JsonProperty(value = "code")
	 public String code;
	 
	 @JsonProperty(value = "errors")
	 public String errors;	
	
}
