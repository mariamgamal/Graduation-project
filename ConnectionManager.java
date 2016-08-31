package com.obdgp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager
{
	//Connection with database
	private static Connection conn ;
	static Statement st=null;
	public static final String host="jdbc:mysql://db4free.net:3306/obdgpdb", username="oumar", pswd="vodafone";
	//public static final String host="jdbc:mysql://fdb14.awardspace.net:3306/2138130_obdgp", username="2138130_obdgp", pswd="vodafone1";
	    public static Connection getConnection()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            	if(conn == null)
	            	{
	            		System.out.println("************************* Trying to get a connection with host: "+host
	        					+"\n username = "+username+ "\t\t pass = "+pswd+"*************************");
	        			
	       
	        			
	            	conn = DriverManager.getConnection(host, username, pswd);
	            	st = conn.createStatement();
	            	System.out.println(conn);
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
	        return conn;
	    }
	    
	    
	    
public void closeConnection()
		{
	        try {
	              if (conn != null) 
	              {
	                  conn.close();
	              }
	            } 
	        catch (Exception e) 
	        { 
	                //do nothing
	          }
	    }
}
