package com.obdgp.Services;

import java.sql.SQLException;

import com.obdgp.Daos.UsersDaoo;

public class UsersService {
	UsersDaoo udo;

	public UsersService() {
		super();
	}


	public String getUserID(String _username, String _pass)
	{
		String retrievedID = null;
		udo = new UsersDaoo();
		System.out.println("*************************  NOW in class UsersService/getUserID  *************************");
		try {
			retrievedID = udo.getIDFromDatabase(_username, _pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(retrievedID.equals("-8000"))
			return "notf";
		return retrievedID;
	}

	public String Changepassword(String uname, String oldpass,String newpass) throws SQLException
	{String ret;
	udo = new UsersDaoo();
	System.out.println("*************************  NOW in class UsersService/change password  *************************");
	ret=udo.changePassword(uname, oldpass, newpass);

	return ret;

	}

	public String resetpassword(String email) throws SQLException
	{String ret;
	udo = new UsersDaoo();
	System.out.println("*************************  NOW in class UsersService/reset password  *************************");
	ret=udo.resetPassword(email);
	return ret;

	}




}
