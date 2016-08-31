package com.obdgp.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.obdgp.Models.Device;
import com.obdgp.Models.TableReading;
import com.obdgp.Services.deviceconnection;
import com.obdgp.utils.ConnectionManager;
import com.obdgp.utils.Convertgps;
public class DevicesDaoo {

	Connection con;
	ResultSet res = null;
	ResultSet res2 = null;
	ResultSet res3 = null;
	String status=null;
	DatabaseConnection dbcon = null;
	List<Device> devices = null;
	DateFormat tf = new SimpleDateFormat("HH:mm:ss");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Convertgps cgps=new Convertgps();
	deviceconnection devcon=new deviceconnection();

	/**
	 * 
	 */
	public DevicesDaoo() {
		super();
	}


	public List<Device> getDevicesFromDatabase(String uname) throws SQLException
	{
		System.out.println("  NOW in class DevicessDaoo/getDevicesFromDatabase  \n_____________");	
		try {
			dbcon = new DatabaseConnection();
			Statement st = dbcon.ConnectToDB();


			String query = " SELECT id,DEVICE_NAME, CARMODEL,CARNUMBER,DRIVERNAME,userid,uid,username from devices,users WHERE userid=uid  and username= '"+uname+"'";
			query = query.toLowerCase();
			res = st.executeQuery(query);

			boolean tr=res.next();
			devices = new ArrayList<Device>();
			Date t = new Date();
			String b=tf.format(t);
			String day=df.format(t);
			String [] a1=b.split(":");
			int x=0;
			String [] dataArray=null;
			String lat=null;
			String lon=null;
			String [] latar=null;
			String [] lonar=null;
			String latit=null;
			String longt=null;
			if(tr)
			{

				res.beforeFirst();

				while(res.next())	
				{ Device addedDev = new Device();
				addedDev.setDeviceID(res.getString("id"));
				addedDev.setDeviceName(res.getString("device_name"));
				addedDev.setCarmodel(res.getString("carmodel"));
				addedDev.setCarnumber(res.getString("carnumber"));
				addedDev.setDrivername(res.getString("drivername"));

				Statement st2 = dbcon.ConnectToDB();

				query=" SELECT time,location_latitude,location_longitude, date FROM readings WHERE  device_id= '"+res.getString("id")+"' ORDER BY date DESC,time DESC LIMIT 1";
				res2=st2.executeQuery(query);

				if(res2.next())
				{

					if(StringUtils.isNullOrEmpty(lat))
					{
						latit="0";

					}
					else if (lat.substring(0,1).equals("0"))
					{
						latar=lat.substring(1, lat.length()).split("");
						latit=cgps.convertDMS(Double.parseDouble(latar[0]+latar[1]),Double.parseDouble(latar[2]+latar[3]+latar[4]+latar[5]+latar[6]+latar[7]+latar[8]+latar[9]),Double.parseDouble("0"));
					}
					else{latar=lat.split("");
					latit=cgps.convertDMS(Double.parseDouble(latar[0]+latar[1]),Double.parseDouble(latar[2]+latar[3]+latar[4]+latar[5]+latar[6]+latar[7]+latar[8]+latar[9]),Double.parseDouble("0"));
					}


					if(StringUtils.isNullOrEmpty(lon))
					{
						longt="0";

					}
					else if (lon.substring(0,1).equals("0"))
					{
						lonar=lon.substring(1, lon.length()).split("");
						longt=cgps.convertDMS(Double.parseDouble(lonar[0]+lonar[1]),Double.parseDouble(lonar[2]+lonar[3]+lonar[4]+lonar[5]+lonar[6]+lonar[7]+lonar[8]+lonar[9]),Double.parseDouble("0"));

					}
					else{lonar=lon.split("");
					longt=cgps.convertDMS(Double.parseDouble(lonar[0]+lonar[1]),Double.parseDouble(lonar[2]+lonar[3]+lonar[4]+lonar[5]+lonar[6]+lonar[7]+lonar[8]+lonar[9]),Double.parseDouble("0"));
					}
				addedDev.setConnected(devcon.Getconnection(addedDev.getDeviceName()));
				System.out.println("Connection="+addedDev.getConnected());
				}
				else {
					st2.executeUpdate("UPDATE devices SET connected = '0' Where device_name= '"+res.getString("device_name")+"'");
					addedDev.setConnected(devcon.Getconnection(addedDev.getDeviceName()));
				}

				devices.add(addedDev);
				dbcon.closeConnection();
				}

			}


			else{		
				System.out.println("No Devices Found");}

			dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*************************  Exiting DevicesDaoo/getDevicesFromDatabase  *************************");


		return devices;
	}

	
	

	public String Removedevice(String uname ,String dev_name) throws SQLException
	{    
		con=ConnectionManager.getConnection();
		System.out.println("*************************  NOW in class DevicesDao/Adding new dev in db *************************");
		dbcon = new DatabaseConnection();
		Statement st = dbcon.ConnectToDB();
		String userid=null;
		String devid=null;
		String idtodelete=null;
		String query;
		String ret=null;

		try {


			System.out.println("*************************  Executing Query  *************************");
			query="select uid from users where username =  '"+uname+"'";
			res = st.executeQuery(query);
			if(res.next())
			{
				userid=res.getString("uid");

			}
			else{}

			query="select * from devices where device_name='"+dev_name+"' and userid= '"+userid+"'";
			res2 = st.executeQuery(query);

			if(res2.next()==true){

				idtodelete=res2.getString("id");

				query="DELETE FROM devices WHERE  id = '"+idtodelete+"' and device_name= '"+dev_name+"'";

				
				st.execute(query);

				ret="Deleted successfully ";

			}

			else{
				ret="No dev to delete";
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			ret="Problem occured";
			System.out.println(e);
			e.printStackTrace();

		}
		return ret;	
	}

	public String ADDdevice(String uname,String dev_name,String carmodel,String carnumber, String drivername,String serial_no) throws SQLException
	{    
		con=ConnectionManager.getConnection();
		System.out.println("*************************  NOW in class DevicesDao/Adding new dev in db *************************");
		dbcon = new DatabaseConnection();
		Statement st = dbcon.ConnectToDB();
		con=dbcon.getConnection();
		String userid=null;
		String devid=null;
		String query;
		String ret=null;



		try {


			System.out.println("*************************  Executing Query  *************************");
			query="select uid from users where username =  ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,  uname);
			res = ps.executeQuery();
			if(res.next())
			{
				userid=res.getString("uid");
				query="select id from devices ORDER BY id DESC LIMIT 1 ";

				res = st.executeQuery(query);
				if(res.next())
				{
					devid=res.getString("id");

					devid=Integer.toString((Integer.parseInt(devid)+1));


				}
				query="select * from devices where device_name=? and carmodel=? and carnumber=? and drivername=? and userid=? and serial_number=?";
				ps = con.prepareStatement(query);
				ps.setString(1,  dev_name);
				ps.setString(2,  carmodel);
				ps.setString(3,  carnumber);
				ps.setString(4,  drivername);
				ps.setString(5,  userid);
				ps.setString(6,  serial_no);
				res = ps.executeQuery();
				if(res.next())
				{
					ret="Device already exists";

				}
				else{
					query="select * from devices where serial_number =? ";
				ps = con.prepareStatement(query);
				ps.setString(1,  serial_no);
				res = ps.executeQuery();
				if(res.next())
					{ret="This serial number is used by another device";
					
					}
					else{
					query="select * from serial_numbers where numbers=?";
					ps = con.prepareStatement(query);
					ps.setString(1,  serial_no);
					res = ps.executeQuery();
					if(!res.next())
					{
						ret="Make sure you enterd serial number on the device";

					}
					else{
					query = "INSERT INTO devices(id,device_name,carmodel,carnumber,drivername,userid,Serial_number) VALUES (?,?,?,?,?,?,?)";

					ps = con.prepareStatement(query);
					ps.setString(1,  devid);
					ps.setString(2,  dev_name);
					ps.setString(3,  carmodel);
					ps.setString(4,  carnumber);
					ps.setString(5,  drivername);
					ps.setString(6,  userid);
					ps.setString(7,  serial_no);
					ps.executeUpdate();
					
					ret="Device added";}}

				}
			}
			else{
				ret="User doesnt exist";
			}

			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			ret="Problem occured re add device again";
			System.out.println(e);
			e.printStackTrace();

		}
		return ret;	

	}
	
	public String Updatedevice(String uname,String dev_name,String new_devname,String carmodel,String carnumber, String drivername,String serial_no) throws SQLException
	{    
		con=ConnectionManager.getConnection();
		System.out.println("*************************  NOW in class DevicesDao/Adding new dev in db *************************");
		dbcon = new DatabaseConnection();
		Statement st = dbcon.ConnectToDB();
		con=dbcon.getConnection();
		String userid=null;
		String devid=null;
		String query;
		String ret=null;



		try {


			System.out.println("*************************  Executing Query  *************************");
			query="select uid from users where username =  ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,  uname);
			res = ps.executeQuery();
			if(res.next())
			{
				userid=res.getString("uid");
				query="select id,device_name from devices where device_name=?";
				ps = con.prepareStatement(query);
				ps.setString(1,  dev_name);
				res = ps.executeQuery();
				if(res.next())
				{
				devid=res.getString("id");	
				query="select * from devices where serial_number =? and id !=?";
				ps = con.prepareStatement(query);
				ps.setString(1,  serial_no);
				ps.setString(2,  devid);
				res = ps.executeQuery();
				if(res.next())
					{
					ret="This serial number is used by another device";
					
					}
					else{
					query="select * from serial_numbers where numbers=?";
					ps = con.prepareStatement(query);
					ps.setString(1,  serial_no);
					res = ps.executeQuery();
					if(!res.next())
					{
						ret="Make sure you enterd serial number on the device";

					}
					else{
					query = "UPDATE  devices set device_name=?,carmodel=?,carnumber=?,drivername=?,userid=?,Serial_number=? where id=?";

					ps = con.prepareStatement(query);
					ps.setString(7,  devid);
					ps.setString(1,  new_devname);
					ps.setString(2,  carmodel);
					ps.setString(3,  carnumber);
					ps.setString(4,  drivername);
					ps.setString(5,  userid);
					ps.setString(6,  serial_no);
					ps.setString(7,  devid);
					ps.executeUpdate();
					
					ret="Device updated";}}
				}		
					
				else{
					ret="incorrect devicename";
				}

				
			}
			else{
				ret="User doesnt exist";
			}

			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			ret="Problem occured update device again";
			System.out.println(e);
			e.printStackTrace();

		}
		return ret;	

	}

	
	
	
}