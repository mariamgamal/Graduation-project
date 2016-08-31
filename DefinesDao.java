package com.obdgp.Daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class DefinesDao {


	Connection con;
	ResultSet res = null;
	String status=null;
	DatabaseConnection dbcon = null;
	Map<String, String> definesMap;

	/**
	 * 
	 */
	public DefinesDao() {
		super();
	}


	public Map<String,String> getDefinesFromDatabase() throws SQLException
	{
		System.out.println("*************************  NOW in class DefinesDao/getDefinesFromDatabase  *************************");	
		try {
			dbcon = new DatabaseConnection();
			Statement st = dbcon.ConnectToDB();
			String query = " SELECT settings_key,settings_value FROM system_settings ";
			System.out.println("*****************  Executing Query: "+query+" *****************");
			res = st.executeQuery(query);
			definesMap = new HashMap<String,String>();
			if(res.next())
			{
				res.beforeFirst();
				while(res.next())
				{
					System.out.println(res.getString("settings_key")+"\t"+res.getString("settings_value"));
					definesMap.put(res.getString("settings_key"), res.getString("settings_value"));
				}
			}
			else
			{
				System.out.println("No Devices Found");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbcon.closeConnection();
		System.out.println("*************************  Exiting DefinesDao/getDefinesFromDatabase  *************************");
		return definesMap;
	}
	
}
