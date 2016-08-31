package com.obdgp.Services;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.obdgp.Daos.*;
import com.obdgp.Models.TableReading;


public class ReadingService {


	TablereadingDao tro= new TablereadingDao();
	public List<String> getTblreading(String id ) throws SQLException{
		System.out.println("*************************  NOW in class ReadingService/getTBLreading *************************");
		List<String>  reading = new ArrayList<String>();
		List<TableReading> devList = tro.getReadingsFromDB(id);
		
		String params="time,date,RPM,SPEED,ENGINE_LOAD,COOLANT_TEMP,SHORT_FUEL_TRIM_1,INTAKE_PRESSURE,INTAKE_TEMP,THROTTLE_POS,DISTANCE_SINCE_DTC_CLEAR,DISTANCE_W_MIL,RUN_TIME,FUEL_STATUS,FUEL_PRESSURE,RELATIVE_THROTTLE_POS,THROTTLE_ACTUATOR,THROTTLE_POS_B,TIMING_ADVANCE,EVAPORATIVE_PURGE,LONG_FUEL_TRIM_2,LONG_O2_TRIM_B1,AMBIANT_AIR_TEMP,AIR_STATUS,OIL_TEMP,HYBRID_BATTERY_REMAINING,ABSOLUTE_LOAD,FUEL_LEVEL,EGR_ERROR,EVAP_VAPOR_PRESSURE,FUEL_INJECT_TIMING,O2_B1S2,O2_B1S1,CATALYST_TEMP_B1S1,BAROMETRIC_PRESSURE,ACCELERATOR_POS_E,ACCELERATOR_POS_D,EVAPORATIVE_PURGE,WARMUPS_SINCE_DTC_CLEAR,CONTROL_MODULE_VOLTAGE,STATUS_DRIVE_CYCLE,COMMAND_EQUIV_RATIO,ACCELERATOR_POS_E,";
		String [] param	=params.split(",");
		if(devList.isEmpty() )
		{
			reading.add("No Readings found!!!");
		}
		{
			for(int i=0 ; i<devList.size() ; i++)
			{
				for(int x=0; x<param.length;x++)
				{	
					if(  !StringUtils.isNullOrEmpty(devList.get(i).getParam(param[x]))&&!devList.get(i).getParam(param[x]).equals("NoneNone")&&!devList.get(i).getParam(param[x]).equals("nonenone") )
					{
						reading.add(param[x]+"="+devList.get(i).getParam(param[x]));}
				}


			}
		}

		return reading;
	}


	public List<String> getImportantReadings(String id ) throws SQLException{
		System.out.println("*************************  NOW in class ReadingService/getIMPreading *************************");
		
		String params="time,date,RPM,ENGINE_LOAD,THROTTLE_POS,SPEED,OIL_TEMP,HYBRID_BATTERY_REMAINING,ABSOLUTE_LOAD,COOLANT_TEMP,EVAP_VAPOR_PRESSURE,EGR_ERROR,FUEL_LEVEL,INTAKE_TEMP,FUEL_INJECT_TIMING";
		String [] param=params.split(",");		

		List<String>  reading = new ArrayList<String>();
		List<TableReading> devList = tro.getImportantReadingsFromDB(id);
		if(devList.isEmpty() )
		{
			reading.add("NO Important Readings found!!!");
		}
		else
		{
			for(int i=0 ; i<devList.size() ; i++)
			{

				for(int x=0; x<param.length;x++)
				{	

					if(  !StringUtils.isNullOrEmpty(devList.get(i).getParam(param[x]))&&!devList.get(i).getParam(param[x]).equals("NoneNone")&&!devList.get(i).getParam(param[x]).equals("nonenone") )
					{
						reading.add(param[x]+"="+devList.get(i).getParam(param[x]));}
				}

			}
		}

		return reading;
	}


	public List<String> getSelectReadings(String id, String param ) throws SQLException{
		List<String>  reading = new ArrayList<String>();
		List<TableReading> devList = tro.getSelectedReadingsFromDB(id,param);
		String [] dataArray=param.split(",");
		if(devList.isEmpty() )
		{
			reading.add("NO Important Readings found!!!");
		}
		else
		{

			for(int i=0; i<dataArray.length;i++)
			{	
				reading.add(param+devList.get(i).getParam(param));
			}
		}

		return reading;
	}


	public void Insertdata(String id) throws SQLException
	{
		tro.InsertTBReadings(id);

	}




	public String[][] getyearlyd(String y1,String y2,String id,String param , int size1, int size2) throws SQLException{


		System.out.println("*************************  NOW in class ReadingService/yearlycharts *************************");

		String[][] reading = new String[size2][size1+1];
		reading= tro.getChartYdata(y1,y2,id,param);

		return reading;
	}
	public String[][] gethourlyd(String day,String dev_name,String param,int size1) throws SQLException{

		System.out.println("*************************  NOW in class ReadingService/hourlycharts *************************");

		int size2=25;
		String[][] reading = new String[size2][size1+1];
		reading= tro.getChartHourlydata(day,dev_name,param);

		return reading;
	}
	public String[][] getMonthlyd(String y1,String y2,String id,String param , int size1, int size2) throws SQLException{

		System.out.println("*************************  NOW in class ReadingService/monthlycharts *************************");
		
		String[][] reading = new String[size2][size1+1];
		reading= tro.getChartMdata(y1,y2,id,param);


		return reading;
	}

	public String[][]	getDailyd(String y1,String y2,String id,String param,int size1,int size2 ) throws SQLException
	{System.out.println("*************************  NOW in class ReadingService/dailycharts *************************");
	
		String[][] reading = new String[size2][size1+1];
		String[][] out = new String[size2][size1+1];
		reading= tro.getChartDdata(y1,y2,id,param);

		return reading;
	}


	public String[]	getLocation(String uname,String devname) throws SQLException
	{System.out.println("*************************  NOW in class ReadingService/getlocation*************************");
	
		TableReading addedDev = new TableReading();
		String[] reading = new String[5];
		addedDev= tro.getloc(uname,devname);

		String [] loc=addedDev.getLocation().split(",");

		String x=loc[0];
		String y=loc[1];
		reading[0]=x;
		reading[1]=y;
		reading[2]=addedDev.getTime();
		reading[3]=addedDev.getDate();
		reading[4]=addedDev.getConnection();


		return reading;
	}

	public String	Sendmessage() throws SQLException
	{
		System.out.println("*************************  NOW in class ReadingService/send msg *************************");
		
		String reading = null;
		reading=tro.Sendsms();

		return reading;
	}

	public String[]	getdangerousness(String dev_name) throws SQLException
	{
		System.out.println("*************************  NOW in class ReadingService/getdangerous *************************");
		

		String [] reading = null;
		reading=tro.getdangerousnes(dev_name);

		return reading;
	}

}
