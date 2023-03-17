package org.teckArk.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseApiResponse {

	@JsonProperty(value = "status")
	 public String status;

	@JsonProperty(value = "message")
	 public String message;
	 
	 /*@JsonProperty(value = "data")
	 public T data;*/
}
