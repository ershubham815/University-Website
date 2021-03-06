package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.DClubBean;
import com.mvc.util.DBConnection;

public class DClubDao {
	
	public String deleteClub(DClubBean DClubBean)
	{
	
	String ClubName=DClubBean.getClubName();


	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
		con = DBConnection.createConnection();
		String query = "delete from club where ClubName=?"; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

		preparedStatement.setString(1, ClubName);
		
		int i= preparedStatement.executeUpdate();
		if (i!=0)  //Just to ensure data has been inserted into the database
		return "SUCCESS"; 
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}

}
