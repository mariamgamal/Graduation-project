package com.obdgp.Models;


public class Device {

	private String deviceID;
	private String deviceName;
	private String carmodel;
	private String carnumber;
	private String drivername;
	private String connected;
	private String location;

	/**
	 * @param deviceID
	 * @param carmodel
	 * @param carnumber
	 * @param drivername
	 */
	public Device(String deviceID, String deviceName, String carmodel, String carnumber, String drivername,String connected,String loc) {
		super();
		this.deviceID = deviceID;
		this.deviceName = deviceName;
		this.carmodel = carmodel;
		this.carnumber = carnumber;
		this.drivername = drivername;
		this.connected=connected;
		this.location=loc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getConnected() {
		return connected;
	}

	public void setConnected(String coonected) {

		this.connected = coonected;

	}

	/**
	 * 
	 */
	public Device() {
		super();
	}

	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String string){ this.carnumber = string;} 

	public String getDrivername() {return drivername;}
	public void setDrivername(String drivername) {this.drivername = drivername;}
	public String getDeviceID() {return deviceID;}
	public void setDeviceID(String deviceID) {this.deviceID = deviceID;}
	public String getCarmodel() {return carmodel;}
	public void setCarmodel(String carmodel) {this.carmodel = carmodel;}
	public String getDeviceName() {return deviceName;}
	public void setDeviceName(String deviceName) {this.deviceName = deviceName;}

	public String toString(){
		return "ID: "+deviceID+" Name: "+drivername;
	}



}


