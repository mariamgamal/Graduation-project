package com.obdgp.Services;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.obdgp.Daos.DevicesDaoo;
import com.obdgp.Daos.TablereadingDao;
import com.obdgp.Models.Device;


public class DeviceService {
	DevicesDaoo devDaoo = new DevicesDaoo();
	TablereadingDao tbdao=new TablereadingDao();

	public List<String> getDevices(String uname) throws SQLException{
		List<String>  devIDs = new ArrayList<String>();
		List<Device> devList = devDaoo.getDevicesFromDatabase(uname);

		if(devList.isEmpty())
		{
			devIDs.add("-8000");
		}
		else
		{

			for(int i=0 ; i<devList.size() ; i++)

			{

				if(devList.get(i).getConnected().equals("1"))
				{devIDs.add(devList.get(i).getDeviceName()+","+devList.get(i).getConnected());
				
				}
				else
				{
					devIDs.add(devList.get(i).getDeviceName()+","+devList.get(i).getConnected());
				}
			}
		}

		return devIDs;

	}

	public String addNewDevices(String uname,String dev_name,String carmodel,String carnumber, String drivername,String serialnumber) {
		String ret=null;
		try {
			ret=devDaoo.ADDdevice(uname, dev_name, carmodel, carnumber, drivername,serialnumber);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	public String UpdateDevice(String uname,String dev_name,String newname,String carmodel,String carnumber, String drivername,String serialnumber) {
		String ret=null;
		try {
			ret=devDaoo.Updatedevice(uname, dev_name,newname, carmodel, carnumber, drivername,serialnumber);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}


	public String DeleteDevices(String  uname,String dev_name) {
		String ret=null;
		try {
			ret=devDaoo.Removedevice( uname,dev_name);

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

}
