package com.rmgyantra.GenericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;



public class ApiBaseClass {
	
 DataBaseUtility dblib=new DataBaseUtility();          
 @BeforeSuite
 public void configureBeforeSuite() {
	 baseURI="http://localhost:8084";
	 dblib.connectDB();
	 
	 }

 @AfterSuite
 public void configureAfterSuite() throws Throwable  {
	 dblib.closeDB();
 }
 
 
}
