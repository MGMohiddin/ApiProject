package com.rmgyantra.projecttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.GenericUtility.ApiBaseClass;
import com.rmgyantra.GenericUtility.CreatePojoLib;
import com.rmgyantra.GenericUtility.DataBaseUtility;
import com.rmgyantra.GenericUtility.IEndPoints;
import com.rmgyantra.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddProjectWithCompletedStatus extends ApiBaseClass {
	DataBaseUtility dblib=new DataBaseUtility();
	
	
@Test
public void addProjectWithCompletedStatus() throws Throwable {
	String Status="completed";
	String ProjectName="Sdet22"+ JavaUtility.getRandomData();
	CreatePojoLib pojlib = new CreatePojoLib("FaisalMGM", ProjectName, Status, 17);
	
	
	//Execute Api and get the data & verify
     Response resp = given().contentType(ContentType.JSON).body(pojlib)
     .when().post(IEndPoints.AddProjectWithCompletedStatus_EndPoint);
    resp.then().assertThat().statusCode(201).log().all();
     
     
     
     String apirespProjectName = resp.jsonPath().get("projectName");
     System.out.println(apirespProjectName);
    
   //connect to db & get the data 
    
   String dbprojectName = dblib.executeQueryAndVerifyAndGetData("select * from project", 4, apirespProjectName);
   String dbstatus = dblib.executeQueryAndVerifyAndGetData("select * from project", 5, Status);
   
   Assert.assertEquals(dbprojectName, apirespProjectName);
   Assert.assertEquals(dbstatus, Status);
	
	
	
}

}
