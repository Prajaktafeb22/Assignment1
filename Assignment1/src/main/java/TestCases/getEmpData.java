package TestCases;

import java.util.HashMap;
import java.util.List;

import org.techArk.utils.EnvironmentDetails;
import org.teckArk.responsePOJO.Employee;
import org.teckArk.responsePOJO.GetEmployeeResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class getEmpData {

	@Test(description="Testcase1")
	public void getEmployeeData() {
		
		System.out.println("excuting get emp data");
		
		//RestAssured.baseURI = EnvironmentDetails.getProperty("baseURI");
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		HashMap<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		//headers.put("token", token);
		Response res = RestAssured.given().headers(headers).get("api/v1/employees");
		
		System.out.println("Status code " + res.getStatusCode());
		Assert.assertEquals(200, res.getStatusCode());
		GetEmployeeResp employeeResp = res.getBody().as(new TypeRef<GetEmployeeResp>() {});
		System.out.println(employeeResp.status);
		Assert.assertEquals("success",employeeResp.status);
		System.out.println("Record count is " + employeeResp.employeelist.size());
		
//		for(Employee emp : employeeResp.employeelist )
//		{
//			System.out.println(emp.employee_name);
//		}
		
		//System.out.println(res.asPrettyString());
		
	}
	
	
	
	
	
	
	
	
}
