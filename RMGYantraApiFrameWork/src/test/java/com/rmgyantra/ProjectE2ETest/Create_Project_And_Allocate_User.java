package com.rmgyantra.ProjectE2ETest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmgyantra.GenericUtility.CreatePojoLib;
import com.rmgyantra.GenericUtility.JavaUtility;
import com.rmgyantra.GenericUtility.UserPojoLib;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Project_And_Allocate_User {
	
	@Test
	public void createProjectAndAllocateUser() {
		
		String Status="completed";
		String ProjectName="Sdet22"+ JavaUtility.getRandomData();
		CreatePojoLib pojlib = new CreatePojoLib("FaisalMGM", ProjectName, Status, 17);
		
		//Execute Api and get the data & verify
	     Response resp = given().contentType(ContentType.JSON).body(pojlib)
	     .when().post("http://localhost:8084/addProject");
	    resp.then().assertThat().statusCode(201).log().all();
	     
	     String apirespProjectName = resp.jsonPath().get("projectName");
	     System.out.println(apirespProjectName);
    
	      //Create user for above project
	     
	     UserPojoLib empPojolib= new UserPojoLib("SdetEng", "22/10/1996", "gouse@gmail.com", "gouse", 3, "8500712617", apirespProjectName, "ROLE_EMPLOYEE", "mohiddin");
	     
	     given().contentType(ContentType.JSON).body(empPojolib)
	  	     .when().post("http://localhost:8084/employees")
	     .then().log().all();
	     
	 }

}
