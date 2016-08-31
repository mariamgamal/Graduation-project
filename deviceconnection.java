package com.obdgp.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.StringUtils;
import com.obdgp.Daos.DatabaseConnection;
import com.obdgp.Models.Device;

public class deviceconnection {
	DatabaseConnection dbcon = null;
	ResultSet res = null;



	public String Getconnection(String dev_name) 
	{ String connection="0";

	try {

		dbcon = new DatabaseConnection();
		Statement st = dbcon.ConnectToDB();
		DateFormat tf = new SimpleDateFormat("HH:mm:ss");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


		String query = " SELECT time,date from readings,devices WHERE device_id=id and device_name='"+dev_name+"' ORDER BY date DESC,time DESC LIMIT 1";
		query = query.toLowerCase();
		//System.out.println("***************** getting connection "+query+" *****************");
		res = st.executeQuery(query);
		//boolean tr=res.next();
		Date t = new Date();
		String b=tf.format(t);
		String day=df.format(t);
		String [] a1=b.split(":");
		int x=0;
		String [] dataArray=null;
		while(res.next())
		{
			dataArray= res.getString("time").split(":");
			x= Integer.parseInt( a1[2])-Integer.parseInt(dataArray[2]);	

			if(day.equals(res.getString("date")) && dataArray[0].equals(a1[0])&&dataArray[1].equals(a1[1]) )
			{
				connection="1";

			}
			else {
				connection="0";
			}

			dbcon.closeConnection();
		}


	} catch (Exception e) {
		System.out.println("handeling exception");
		// TODO Auto-generated catch block
	}

	return connection;
	}

}
