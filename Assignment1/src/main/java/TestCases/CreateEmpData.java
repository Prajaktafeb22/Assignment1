package TestCases;

import java.text.MessageFormat;
import java.util.HashMap;

import org.teckArk.responsePOJO.BaseApiResponse;
import org.teckArk.responsePOJO.DeleteEmployeeResponse;
import org.teckArk.responsePOJO.Employee;
import org.teckArk.responsePOJO.GetEmployeeResp;
import org.teckArk.responsePOJO.reasponse;
import org.teckArk.responsePOJO.createEmployee.CreateEmployeeResponse;
import org.teckArk.responsePOJO.createEmployee.CreatedEmployee;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class CreateEmpData {
	private int employeeid=0;
	
//	@BeforeClass
//	public void setUp() {
//		
//		RestAssured.baseURI = "https://dummy.restapiexample.com";
//		
//	}
	
	@Test(description="testcase 2" ,priority=1)
	public void createEmpData() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/create";
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("content-type","application/json");		 
		
		HashMap<String, String> body = new HashMap<String, String>();
		
		String name = "test";
		String sal ="123";
		String age ="23";
		body.put("name",name);
		body.put("salary",sal);
		body.put("age",age);
		
		
		Response res = RestAssured.given().headers(headers)
				 .when().body(body).post()
				 .then().statusCode(200).extract().response();
		Assert.assertEquals(200, res.getStatusCode());
		
		CreateEmployeeResponse createEmployeeResponse = res.getBody().as(new TypeRef<CreateEmployeeResponse>() {});
		
		Assert.assertEquals(name, createEmployeeResponse.dataResponse.name);
		Assert.assertEquals(sal, createEmployeeResponse.dataResponse.salary.toString());
		Assert.assertEquals(age, createEmployeeResponse.dataResponse.age.toString());
		//System.out.println(res.asPrettyString());
		employeeid=createEmployeeResponse.dataResponse.id;
		
	
	}
	
	@Test(priority=2,dependsOnMethods={"createEmpData"},description="testcase 3")
     public void deleteEmpData() {
		
		RestAssured.baseURI=MessageFormat.format("https://dummy.restapiexample.com/public/api/v1/delete/{0}", employeeid);
		HashMap<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		Response res = RestAssured.given().headers(headers)
				                  .when().delete()
				                  .then().statusCode(200).extract().response();
//		System.out.println(res.asPrettyString());
//		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode() , 200);
		//DeleteEmployeeResponse deleteEmployeeResponse = GetResponse(res);
		
		DeleteEmployeeResponse deleteEmployeeResponse = res.getBody().as(new TypeRef<DeleteEmployeeResponse>() {});
		System.out.println(deleteEmployeeResponse.status);
		Assert.assertEquals("success", deleteEmployeeResponse.status);
		//System.out.println(res.asPrettyString());
		System.out.println(deleteEmployeeResponse.message);
	}
  
	//dependsOnMethods={"deleteEmpData"}
	@Test(priority=3,description="testcase 4")
    public void deleteDeletedEmpData() {
		System.out.println("deleteDeletedEmpData ");
		RestAssured.baseURI="https://dummy.restapiexample.com/public/api/v1/delete/0";
		HashMap<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		Response res = RestAssured.given().headers(headers)
				                  .when().delete()
				                  .then().statusCode(400).extract().response();
//		System.out.println(res.asPrettyString());
//		System.out.println(res.getStatusCode());
		
		
		//DeleteEmployeeResponse deleteEmployeeResponse = GetResponse(res);
		
		DeleteEmployeeResponse deleteEmployeeResponse = res.getBody().as(new TypeRef<DeleteEmployeeResponse>() {});
		//System.out.println(deleteEmployeeResponse.status);
		
		
		
		Assert.assertEquals(res.getStatusCode() ,400);// Should be 400 here
		Assert.assertEquals(deleteEmployeeResponse.status,"error");		
		System.out.println(deleteEmployeeResponse.message);
	}
	
//	private static <T> T GetResponse(Response res)
//	{
//		return res.getBody().as(new TypeRef<T>() {});
//	}
//	
	
	@Test(priority=4,description="testcase 5")
	public void getDetailsOfUser() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		HashMap<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type","application/json");
		//headers.put("token", token);
		Response res = RestAssured.given().headers(headers).get("/api/v1/employee/2");
		
		System.out.println("test case 5 "+res.getStatusCode());
		System.out.println("test case 5 "+res.asPrettyString());
		reasponse employeeResp = res.getBody().as(new TypeRef<reasponse>() {});
		
		Assert.assertEquals(employeeResp.employee.employee_name, "Garrett Winters");
		Assert.assertEquals(employeeResp.employee.employee_salary, "170750");
		Assert.assertEquals(employeeResp.employee.employee_age,"63");
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Assert.assertEquals(res.contentType(), "application/json");
		
		
	}
	
	
	
	
}
