package com.rmgyantra.GenericUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


/**
 * @author MD G MOHIDDIN
 */

public class DataBaseUtility {
	
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * This method will perform the sql database connection
	 */

	
	public void connectDB() {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(IConstants.dbURL,IConstants.password,IConstants.username);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close the mysql database
	 * @throws SQLException 
	 */
	
	public void closeDB() throws SQLException {
		connection.close();
	}
	
	
	public ResultSet executeQuery(String query) {
		try {
			result= connection.createStatement().executeQuery(query);
			return result;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;	
		
	}
	
	
	public String executeQueryAndVerifyAndGetData(String querry, int columnName, String exceptedData) throws SQLException {
		boolean flag=false;
		result=connection.createStatement().executeQuery(querry);
		while(result.next()) {
			if(result.getString(columnName).equals(exceptedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(exceptedData+"==>Data is verfied in the database table");
			return exceptedData;
		}
		else {
			System.out.println(exceptedData+"==>Data is not verfied in the database table");
			return exceptedData;
		}
			
	}
}
