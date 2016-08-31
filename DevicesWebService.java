package com.obdgp.webservices;

import com.obdgp.Services.DefinesService;
import com.obdgp.Services.DeviceService;
import com.obdgp.Services.ReadingService;
import com.obdgp.webservices.TablereadingWebService.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;


@RestController
public class DevicesWebService {


	private DeviceService ds;

	//@CrossOrigin(origins = "http://localhost:4040")

	@RequestMapping(value = "/GetDevices",method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody List<String> GetDevices(@RequestBody(required = false)String uname) {
		// TODO: Agree on function's input parameters
		System.out.println("*************************Devices Web Service,"
				+ " trying to retrieve devices.*************************");
		System.out.println("The device name is: "+uname);
		List<String> devicesIDs = null;
		ds = new DeviceService();
		try {
			devicesIDs = ds.getDevices(uname);
			String checkString = devicesIDs.get(0);
			if(checkString == "-8000") // the list is empty
			{
				devicesIDs.clear();
				devicesIDs.add("No Devices Found");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return devicesIDs;
	}

	@RequestMapping(value = "/ADDDevices",method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody String[]  AddNewDevices(@RequestBody(required = false)String input) throws SQLException {
		System.out.println("*************************Devices Web Service/Add new dev*************************");
		String [] dataArray=input.split(",");
		String[] ret=null;
		ret = new String[1];
		try{
			ds = new DeviceService();
			ret[0]=ds.addNewDevices(dataArray[0], dataArray[1], dataArray[2],dataArray[3], dataArray[4],dataArray[5]);}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@RequestMapping(value = "/UpdateDevices",method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody String[]  UpdateDevices(@RequestBody(required = false)String input) throws SQLException {
		System.out.println("*************************Devices Web Service/Add new dev*************************");
		String [] dataArray=input.split(",");
		String[] ret=null;
		ret = new String[1];
		try{
			ds = new DeviceService();
			ret[0]=ds.UpdateDevice(dataArray[0], dataArray[1], dataArray[2],dataArray[3], dataArray[4],dataArray[5],dataArray[6]);}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	@RequestMapping(value = "/RemoveDevices",method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody String[]  RemoveDevices(@RequestBody(required = false)String input) throws SQLException {
		System.out.println("*************************Devices Web Service/Add new dev*************************");
		String [] dataArray=input.split(",");
		String[] ret=null;
		ret = new String[1];
		try{
			ds = new DeviceService();
			ret[0]=ds.DeleteDevices(dataArray[0], dataArray[1]);}


		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}












}
