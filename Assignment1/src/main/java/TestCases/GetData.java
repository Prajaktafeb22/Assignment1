package TestCases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import org.techArk.utils.Constants;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;


public class GetData {
	
	@Test(description="find value of username")
	public void getUserName() throws IOException {
	//Classic method of giving json file path
	//String fileContents = Files.readString(Path.of("C:\\Users\\DECOMM\\eclipse-workspace\\Assignment1\\src\\test\\resources\\jsonfile\\jsondata.json"));
		
	//Below line shows reusable way to give json file path through constant(maintaining file path in separate java file)
	String fileContents = Files.readString(Path.of(Constants.JSON_FILE_PATH));
	List<Object> userNameList =JsonPath.read(fileContents,"$[*].username");
	System.out.println("(1) Value of all username : ");
	
	for(Object userName: userNameList) {
		System.out.println(userName);

	}
	
	
}
	@Test(description="find values of all session id")
	public void getValueOfSessionId() throws IOException {
	
		String fileContents2 = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> sessionIdList = JsonPath.read(fileContents2,"$[*].students[*].id"); 
		
		System.out.println("(2) Value of all session id : ");
		for(Object sessionId: sessionIdList) {
			System.out.println(sessionId);

		}
		
		
	}
	@Test(description="find last value of session id")
	public void getValueOfLastSessionId() throws IOException {
		
		String fileContents2 = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> sessionIdList = JsonPath.read(fileContents2,"$[*].students[*].id"); 
		System.out.println("(3) Value of last session id : "+sessionIdList.get(sessionIdList.size()-1));	
	
		
	}
	
	@Test(description= "find username of 1st university")
	public void getUserNameOf1stUniversity() throws IOException {
		
		String fileContent3= Files.readString(Path.of(Constants.JSON_FILE_PATH));
		
		String userNameList = JsonPath.read(fileContent3,"$[0].username");
		System.out.println("(4) Username of 1st university is :" +userNameList);

	}
	
	@Test(description="find name of 2nd university")
	public void getUserNameOf2ndUniversity() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		String userNameList2 = JsonPath.read(fileContent, "$[1].username");
		System.out.println("(5) Username of 2nd university is :" +userNameList2);
		
	}
	
	@Test(description="find number of universities in the list")
	public void getNumberOfUniversities() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> numberOfUniversities = JsonPath.read(fileContent,"$[*].name");
		
		System.out.println("(6) Number of universities : "+numberOfUniversities.size());
		
	}
	
	@Test(description="find all marks of second student of 1st university")
	public void getStudentMarks() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> marksList = JsonPath.read(fileContent,"$[0].students[1].marks");
		System.out.println("(7) All marks of second student of 1st university is : "+marksList);
		
	}
	
	@Test(description="find the second state(in the address) value of first student of 1st university")
	public void valueOfFirstStud() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		LinkedHashMap<String,Object> lastState = JsonPath.read(fileContent,"$[0].students[0].adresss[1]");
		System.out.println("(8) The second state(in the address)value of first student of 1st University is: "+lastState.toString());
		
		
	}
	
	@Test(description="find the second contact value of second student of 2nd university")
	public void valueOfSecondStud() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> contactValue = JsonPath.read(fileContent,"$[1].students[1].contact");
		System.out.println("(9) The second contact value of second student of 2nd university are :");
		for(Object valueOfContactDetails: contactValue) {
			System.out.println(valueOfContactDetails);
	
		}
	}
	
	@Test(description ="find all cities of second student of 2nd university")
    public void getAllCities() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object>allCities=JsonPath.read(fileContent, "$[1].students[1].adresss[*].city");
		System.out.println("(10) All cities of second student of 2nd university are : ");
		for(Object listOfAllCities :allCities) {
			System.out.println(listOfAllCities);
			
		}
		
	}	
	
	@Test(description="find names of all students")
	public void getNamesOfAllStud() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		
		List<Object> namesOfAllStud =JsonPath.read(fileContent,"$[*].students[*].name");
		System.out.println("(11) Names of all students are :");
		for(Object namesOfStud : namesOfAllStud ) {
			
			System.out.println(namesOfStud);
		}	
	}
	
	@Test(description = "find contacts of all students")
	public void getContactOfStud() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> contactsOfStud = JsonPath.read(fileContent,"$[*].students[*].contact");
		System.out.println("(12) Contacts of all students are : ");
		for(Object contactsOfAllStud : contactsOfStud) {
			
			System.out.println(contactsOfAllStud);
		}
		
		
	}
	
	@Test(description ="find adresses of first student of 1st university")
	public void getAddOfFirstStud() throws IOException {
		
		String fileContent =Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> list = JsonPath.read(fileContent, "$[0].students[0].adresss");
		System.out.println("(13) Adresses of first student of 1st university are : ");
		for(Object s : list) {
			
			System.out.println(s.toString());
		}
		
	}
	
	@Test(description="find number of adresses of second student of 2nd university")
	public void getAddOfSecStud() throws IOException {
		
		String fileContent=Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object>numOfAddressStud = JsonPath.read(fileContent,"$[1].students[1].adresss");
		
		System.out.println("(14) Number of adresses of second student of 2nd university are :"+numOfAddressStud.size());	
	}
	
	@Test(description="find the number of student records of 2nd university")
	public void getNumOfStudRecord() throws IOException{
		
		String fileContent=Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object>numOfStudRecord = JsonPath.read(fileContent,"$[1].students");
		
		System.out.println("(15) Number of student records of 2nd university are :"+numOfStudRecord.size());
		
	}
	
	@Test(description="find the number of contacts of second student of 1st university")
	public void getNumOfContSecStud() throws IOException {
		
		String fileContent = Files.readString(Path.of(Constants.JSON_FILE_PATH));
		List<Object> numOfContactOfStud = JsonPath.read(fileContent,"$[0].students[1].contact");
		System.out.println("(16) Number of contacts of second student of 1st university are : "+numOfContactOfStud.size());
		
	}
	
}
