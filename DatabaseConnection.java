package com.obdgp.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;

public class DatabaseConnection {

	//static String host="jdbc:mysql://localhost:3306/obd-gp-dev-1", username="root", pswd="";
	//static String host="jdbc:mysql://localhost:3306/obd-gp-dev-1", username="oumar", pswd="";
//	static String host="jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8119976", username="sql8119976", pswd="tDjtAMN97w";
	public static final String host="jdbc:mysql://db4free.net:3306/obdgpdb", username="oumar", pswd="vodafone";
	//public static final String host="jdbc:mysql://fdb14.awardspace.net:3306/2138130_obdgp", username="2138130_obdgp", pswd="vodafone1";
	
	static Connection  con;
	ResultSet res = null;
	String status=null;

	static Statement st=null;

	public Statement ConnectToDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Unable to find jdbc.Driver");
			System.out.println(e1.getMessage());
		}


		try{

			System.out.println(" Trying to get a connection with host: "+host
					+"\n username = "+username+ "\t\t pass = "+pswd+"\n_________________");
			con = DriverManager.getConnection (host,username,pswd);
			//con.setNetworkTimeout( Executors.newFixedThreadPool(1), 10000);
			st = con.createStatement();

		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return st;
	}

	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if(con == null)
			{
				System.out.println(" Trying to get a conection with host: "+host+"\n username = "+username+ "\t\t pass = "+pswd+"\n________________");
				con = DriverManager.getConnection(host, username, pswd);
				st = con.createStatement();
				//con.setNetworkTimeout( null, 10000);
				System.out.println(con);
			}
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Unable to find jdbc.Driver");
			System.out.println(e.getMessage());
			e.printStackTrace();

		} 
		catch (SQLException e) 
		{

			e.printStackTrace();

		}
		return con;
	}


	public void closeConnection()
	{
		try {
			if (con != null) 
			{
				con.close();
			}
		} 
		catch (Exception e) 
		{ 
			System.out.println(e.getMessage());
		}
	}

}
