package com.obdgp.Models;

import com.mysql.jdbc.StringUtils;

public class TableReading {

	private String time;
	private String RPM;
	private String SPEED;
	private String ENGINE_LOAD;
	private String COOLANT_TEMP;
	private String SHORT_FUEL_TRIM_1;
	private String INTAKE_PRESSURE;
	private String INTAKE_TEMP;
	private String THROTTLE_POS;
	private String DISTANCE_SINCE_DTC_CLEAR;
	private String DISTANCE_W_MIL;
	private String RUN_TIME;
	private String FUEL_STATUS;
	private String FUEL_PRESSURE;
	private String RELATIVE_THROTTLE_POS;
	private String THROTTLE_ACTUATOR;
	private String THROTTLE_POS_B;
	private String TIMING_ADVANCE;
	private String EVAPORATIVE_PURGE;
	private String LONG_FUEL_TRIM_2;
	private String LONG_O2_TRIM_B1;
	private String AMBIANT_AIR_TEMP;
	private String AIR_STATUS;
	private String O2_SENSORS;
	private String location;
	private String connection;
	private String Date;
	private String OIL_TEMP;
	private String HYBRID_BATTERY_REMAINING;
	private String ABSOLUTE_LOAD;
	private String FUEL_LEVEL;
	private String EGR_ERROR;
	private String EVAP_VAPOR_PRESSURE;
	private String FUEL_INJECT_TIMING;
	private String O2_B1S2;
	private String O2_B1S1;
	private String CATALYST_TEMP_B1S1;
	private String BAROMETRIC_PRESSURE;
	private String ACCELERATOR_POS_E;
	private String ACCELERATOR_POS_D;
	private String CONTROL_MODULE_VOLTAGE;
	private String WARMUPS_SINCE_DTC_CLEAR;
	private String STATUS_DRIVE_CYCLE;
	private String COMMAND_EQUIV_RATIO;

	public String getCONTROL_MODULE_VOLTAGE() {

		return CONTROL_MODULE_VOLTAGE;
	}



	public void setCONTROL_MODULE_VOLTAGE(String cONTROL_MODULE_VOLTAGE) {
		if(  !StringUtils.isNullOrEmpty(cONTROL_MODULE_VOLTAGE)&&!cONTROL_MODULE_VOLTAGE.equals("NoneNone") )
		{	String r=cONTROL_MODULE_VOLTAGE.replaceAll("None", " ");
		String x=r.replaceAll("none", " ");
		CONTROL_MODULE_VOLTAGE = x;}
		else
			CONTROL_MODULE_VOLTAGE =cONTROL_MODULE_VOLTAGE;

	}





	public String getWARMUPS_SINCE_DTC_CLEAR() {
		return WARMUPS_SINCE_DTC_CLEAR;
	}



	public void setWARMUPS_SINCE_DTC_CLEAR(String wARMUPS_SINCE_DTC_CLEAR) {
		if(  !StringUtils.isNullOrEmpty(wARMUPS_SINCE_DTC_CLEAR)&&!wARMUPS_SINCE_DTC_CLEAR.equals("NoneNone") )
		{	String r=wARMUPS_SINCE_DTC_CLEAR.replaceAll("None", " ");

		WARMUPS_SINCE_DTC_CLEAR = r;}
		else

			WARMUPS_SINCE_DTC_CLEAR = wARMUPS_SINCE_DTC_CLEAR;
	}



	public String getSTATUS_DRIVE_CYCLE() {
		return STATUS_DRIVE_CYCLE;
	}



	public void setSTATUS_DRIVE_CYCLE(String sTATUS_DRIVE_CYCLE) {
		if(  !StringUtils.isNullOrEmpty(sTATUS_DRIVE_CYCLE)&&!sTATUS_DRIVE_CYCLE.equals("NoneNone") )
		{	String r=sTATUS_DRIVE_CYCLE.replaceAll("None", " ");

		STATUS_DRIVE_CYCLE = r;}
		else
			STATUS_DRIVE_CYCLE = sTATUS_DRIVE_CYCLE;
	}



	public String getCOMMAND_EQUIV_RATIO() {
		return COMMAND_EQUIV_RATIO;
	}



	public void setCOMMAND_EQUIV_RATIO(String cOMMAND_EQUIV_RATIO) {
		if(  !StringUtils.isNullOrEmpty(cOMMAND_EQUIV_RATIO)&&!cOMMAND_EQUIV_RATIO.equals("NoneNone") )
		{	String r=cOMMAND_EQUIV_RATIO.replaceAll("None", " ");
		String x=r.replaceAll("none", " ");
		COMMAND_EQUIV_RATIO = x;}
		else
			COMMAND_EQUIV_RATIO = cOMMAND_EQUIV_RATIO;
	}
	private String device_id;


	public String getConnection() {
		return connection;
	}



	public void setConnection(String connection) {
		this.connection = connection;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getDate() {
		return Date;
	}



	public void setDate(String date) {
		Date = date;
	}


	public String getOIL_TEMP() {
		return OIL_TEMP;
	}



	public void setOIL_TEMP(String oIL_TEMP) {

		OIL_TEMP = oIL_TEMP;
	}



	public String getHYBRID_BATTERY_REMAINING() {
		return HYBRID_BATTERY_REMAINING;
	}



	public void setHYBRID_BATTERY_REMAINING(String hYBRID_BATTERY_REMAINING) {

		HYBRID_BATTERY_REMAINING = hYBRID_BATTERY_REMAINING;
	}



	public String getABSOLUTE_LOAD() {
		return ABSOLUTE_LOAD;
	}



	public void setABSOLUTE_LOAD(String aBSOLUTE_LOAD) {
		if(  !StringUtils.isNullOrEmpty(aBSOLUTE_LOAD)&&!aBSOLUTE_LOAD.equals("NoneNone") )
		{	String r=aBSOLUTE_LOAD.replaceAll("None", " ");
		String x=r.replaceAll("none", " ");

		ABSOLUTE_LOAD = x;}
		else
			ABSOLUTE_LOAD =aBSOLUTE_LOAD;

	}



	public String getFUEL_LEVEL() {
		return FUEL_LEVEL;
	}



	public void setFUEL_LEVEL(String fUEL_LEVEL) {

		FUEL_LEVEL = fUEL_LEVEL;
	}



	public String getEGR_ERROR() {
		return EGR_ERROR;
	}



	public void setEGR_ERROR(String eGR_ERROR) {

		EGR_ERROR = eGR_ERROR;
	}



	public String getEVAP_VAPOR_PRESSURE() {
		return EVAP_VAPOR_PRESSURE;
	}



	public void setEVAP_VAPOR_PRESSURE(String eVAP_VAPOR_PRESSURE) {

		EVAP_VAPOR_PRESSURE = eVAP_VAPOR_PRESSURE;
	}



	public String getFUEL_INJECT_TIMING() {
		return FUEL_INJECT_TIMING;
	}



	public void setFUEL_INJECT_TIMING(String fUEL_INJECT_TIMING) {


		FUEL_INJECT_TIMING = fUEL_INJECT_TIMING;
	}



	public String getDISTANCE_SINCE_DTC_CLEAR() {
		return DISTANCE_SINCE_DTC_CLEAR;
	}



	public void setDISTANCE_SINCE_DTC_CLEAR(String dISTANCE_SINCE_DTC_CLEAR) {
		DISTANCE_SINCE_DTC_CLEAR = dISTANCE_SINCE_DTC_CLEAR;
	}



	public String getDISTANCE_W_MIL() {
		return DISTANCE_W_MIL;
	}



	public void setDISTANCE_W_MIL(String dISTANCE_W_MIL) {
		DISTANCE_W_MIL = dISTANCE_W_MIL;
	}



	public String getRUN_TIME() {
		return RUN_TIME;
	}



	public void setRUN_TIME(String rUN_TIME) {
		RUN_TIME = rUN_TIME;
	}


	public String getFUEL_STATUS() {
		return FUEL_STATUS;
	}



	public void setFUEL_STATUS(String fUEL_STATUS) {
		FUEL_STATUS = fUEL_STATUS;
	}



	public String getFUEL_PRESSURE() {
		return FUEL_PRESSURE;
	}



	public void setFUEL_PRESSURE(String fUEL_PRESSURE) {
		FUEL_PRESSURE = fUEL_PRESSURE;
	}



	public String getRELATIVE_THROTTLE_POS() {
		return RELATIVE_THROTTLE_POS;
	}



	public void setRELATIVE_THROTTLE_POS(String rELATIVE_THROTTLE_POS) {

		RELATIVE_THROTTLE_POS = rELATIVE_THROTTLE_POS;
	}



	public String getTHROTTLE_ACTUATOR() {
		return THROTTLE_ACTUATOR;
	}



	public void setTHROTTLE_ACTUATOR(String tHROTTLE_ACTUATOR) {


		THROTTLE_ACTUATOR = tHROTTLE_ACTUATOR;
	}



	public String getTHROTTLE_POS_B() {
		return THROTTLE_POS_B;
	}



	public void setTHROTTLE_POS_B(String tHROTTLE_POS_B) {

		THROTTLE_POS_B = tHROTTLE_POS_B;
	}



	public String getTIMING_ADVANCE() {
		return TIMING_ADVANCE;
	}



	public void setTIMING_ADVANCE(String tIMING_ADVANCE) {
		TIMING_ADVANCE = tIMING_ADVANCE;
	}



	public String getEVAPORATIVE_PURGE() {

		return EVAPORATIVE_PURGE;
	}



	public void setEVAPORATIVE_PURGE(String eVAPORATIVE_PURGE) {

		EVAPORATIVE_PURGE = eVAPORATIVE_PURGE;

	}



	public String getLONG_FUEL_TRIM_2() {
		return LONG_FUEL_TRIM_2;
	}



	public void setLONG_FUEL_TRIM_2(String lONG_FUEL_TRIM_2) {
		LONG_FUEL_TRIM_2 = lONG_FUEL_TRIM_2;
	}



	public String getLONG_O2_TRIM_B1() {
		return LONG_O2_TRIM_B1;
	}



	public void setLONG_O2_TRIM_B1(String lONG_O2_TRIM_B1) {


		LONG_O2_TRIM_B1 = lONG_O2_TRIM_B1;
	}



	public String getAMBIANT_AIR_TEMP() {
		return AMBIANT_AIR_TEMP;
	}



	public void setAMBIANT_AIR_TEMP(String aMBIANT_AIR_TEMP) {


		AMBIANT_AIR_TEMP = aMBIANT_AIR_TEMP;
	}



	public String getAIR_STATUS() {
		return AIR_STATUS;
	}



	public void setAIR_STATUS(String aIR_STATUS) {
		AIR_STATUS = aIR_STATUS;
	}



	public String getO2_SENSORS() {
		return O2_SENSORS;
	}



	public void setO2_SENSORS(String o2_SENSORS) {
		if(  !StringUtils.isNullOrEmpty(o2_SENSORS)&&!o2_SENSORS.equals("NoneNone") )
		{String r=o2_SENSORS.replaceAll("None", "");

		O2_SENSORS = r;}
		else
			O2_SENSORS =o2_SENSORS;
	}



	public String getO2_B1S2() {
		return O2_B1S2;
	}



	public void setO2_B1S2(String o2_B1S2) {
		O2_B1S2 = o2_B1S2;
	}



	public String getO2_B1S1() {
		return O2_B1S1;
	}



	public void setO2_B1S1(String o2_B1S1) {
		O2_B1S1 = o2_B1S1;
	}



	public String getCATALYST_TEMP_B1S1() {
		return CATALYST_TEMP_B1S1;
	}



	public void setCATALYST_TEMP_B1S1(String cATALYST_TEMP_B1S1) {
		CATALYST_TEMP_B1S1 = cATALYST_TEMP_B1S1;
	}



	public String getBAROMETRIC_PRESSURE() {
		return BAROMETRIC_PRESSURE;
	}



	public void setBAROMETRIC_PRESSURE(String bAROMETRIC_PRESSURE) {


		BAROMETRIC_PRESSURE = bAROMETRIC_PRESSURE;
	}



	public String getACCELERATOR_POS_E() {
		return ACCELERATOR_POS_E;
	}



	public void setACCELERATOR_POS_E(String aCCELERATOR_POS_E) {


		ACCELERATOR_POS_E = aCCELERATOR_POS_E;
	}



	public String getACCELERATOR_POS_D() {
		return ACCELERATOR_POS_D;
	}



	public void setACCELERATOR_POS_D(String aCCELERATOR_POS_D) {


		ACCELERATOR_POS_D = aCCELERATOR_POS_D;
	}


	public TableReading(String device_id, String RPM, String SPEED, String ENGINE_LOAD, String COOLANT_TEMP
			,String SHORT_FUEL_TRIM_1,String INTAKE_PRESSURE,String INTAKE_TEMP,String THROTTLE_POS, String time) {
		super();
		this.device_id = device_id;
		this.SPEED = SPEED;
		this.RPM = RPM;
		this.time = time;
		this.ENGINE_LOAD = ENGINE_LOAD;
		this.COOLANT_TEMP = COOLANT_TEMP;
		this.SHORT_FUEL_TRIM_1 = SHORT_FUEL_TRIM_1;
		this.INTAKE_TEMP = INTAKE_TEMP;
		this.THROTTLE_POS = THROTTLE_POS;
	}



	public void setParam(String param,String val)
	{
		 
		if(param.equals("RPM"))
		{
			setRPM(val);
		}
		else if(param.equals("SPEED"))
		{setSPEED(val);}
		else if(param.equals("ENGINE_LOAD"))
		{setENGINE_LOAD(val);}
		else if(param.equals("COOLANT_TEMP"))
		{setCOOLANT_TEMP(val);}
		else if(param.equals("SHORT_FUEL_TRIM_1"))
		{setSHORT_FUEL_TRIM_1(val);}
		else if(param.equals("INTAKE_PRESSURE"))
		{setINTAKE_PRESSURE(val);}
		else if(param.equals("INTAKE_TEMP"))
		{setINTAKE_TEMP(val);}
		else if(param.equals("THROTTLE_POS"))
		{setTHROTTLE_POS(val);}
		else if(param.equals("DISTANCE_SINCE_DTC_CLEAR"))
		{setDISTANCE_SINCE_DTC_CLEAR(val);}
		else if(param.equals("DISTANCE_W_MIL"))
		{setDISTANCE_W_MIL(val);}
		else if(param.equals("RUN_TIME"))
		{setRUN_TIME(val);}
		else if(param.equals("date"))
		{setDate(val);}
		else if(param.equals("time"))
		{setTime(val);}
		else if(param.equals("FUEL_STATUS"))
		{setFUEL_STATUS(val);}
		else if(param.equals("FUEL_PRESSURE"))
		{setFUEL_PRESSURE(val);}
		else if(param.equals("RELATIVE_THROTTLE_POS"))
		{setRELATIVE_THROTTLE_POS(val);}
		else if(param.equals("THROTTLE_ACTUATOR"))
		{setTHROTTLE_ACTUATOR(val);}
		else if(param.equals("THROTTLE_POS_B"))
		{setTHROTTLE_POS_B(val);}
		else if(param.equals("TIMING_ADVANCE"))
		{setTIMING_ADVANCE(val);}
		else if(param.equals("EVAPORATIVE_PURGE"))
		{setEVAPORATIVE_PURGE(val);}
		else if(param.equals("LONG_FUEL_TRIM_2"))
		{setLONG_FUEL_TRIM_2(val);}
		else if(param.equals("LONG_O2_TRIM_B1"))
		{setLONG_O2_TRIM_B1(val);}
		else if(param.equals("AMBIANT_AIR_TEMP"))
		{setAMBIANT_AIR_TEMP(val);}
		else if(param.equals("AIR_STATUS"))
		{setAIR_STATUS(val);}
		else if(param.equals("O2_SENSORS"))
		{setO2_SENSORS(val);}
		else if(param.equals("O2_B1S2"))
		{setO2_B1S2(val);}
		else if(param.equals("O2_B1S1"))
		{setO2_B1S1(val);}
		else if(param.equals("CATALYST_TEMP_B1S1"))
		{setCATALYST_TEMP_B1S1(val);}
		else if(param.equals("BAROMETRIC_PRESSURE"))
		{setBAROMETRIC_PRESSURE(val);}
		else if(param.equals("ACCELERATOR_POS_E"))
		{setACCELERATOR_POS_E(val);}
		else if(param.equals("ACCELERATOR_POS_D"))
		{setACCELERATOR_POS_D(val);}
		else if(param.equals("EGR_ERROR"))
		{setEGR_ERROR(val);}
		else if(param.equals("OIL_TEMP"))
		{setOIL_TEMP(val);}
		else if(param.equals("ABSOLUTE_LOAD"))
		{setABSOLUTE_LOAD(val);}
		else if(param.equals("HYBRID_BATTERY_REMAINING"))
		{setHYBRID_BATTERY_REMAINING(val);}
		else if(param.equals("FUEL_LEVEL"))
		{setFUEL_LEVEL(val);}
		else if(param.equals("EVAPORATIVE_PURGE"))
		{setEVAPORATIVE_PURGE(val);}
		else if(param.equals("WARMUPS_SINCE_DTC_CLEAR"))
		{setWARMUPS_SINCE_DTC_CLEAR(val);}
		else if(param.equals("CONTROL_MODULE_VOLTAGE"))
		{setCONTROL_MODULE_VOLTAGE(val);}
		else if(param.equals("STATUS_DRIVE_CYCLE"))
		{setSTATUS_DRIVE_CYCLE(val);}
		else if(param.equals("COMMAND_EQUIV_RATIO"))
		{setCOMMAND_EQUIV_RATIO(val);}


	}
	public String getParam(String param) {

		String ret=null;
		if(param.equals("RPM"))
		{
			ret=getRPM();
		}
		else if(param.equals("SPEED"))
		{ret=getSPEED();}
		else if(param.equals("ENGINE_LOAD"))
		{ret=getENGINE_LOAD();}
		else if(param.equals("COOLANT_TEMP"))
		{ret=getCOOLANT_TEMP();}
		else if(param.equals("SHORT_FUEL_TRIM_1"))
		{ret=getSHORT_FUEL_TRIM_1();}
		else if(param.equals("INTAKE_PRESSURE"))
		{ret=getINTAKE_PRESSURE();}
		else if(param.equals("INTAKE_TEMP"))
		{ret=getINTAKE_TEMP();}
		else if(param.equals("THROTTLE_POS"))
		{ret=getTHROTTLE_POS();}
		else if(param.equals("DISTANCE_SINCE_DTC_CLEAR"))
		{ret=getDISTANCE_SINCE_DTC_CLEAR();}
		else if(param.equals("DISTANCE_W_MIL"))
		{ret=getDISTANCE_W_MIL();}
		else if(param.equals("RUN_TIME"))
		{ret=getRUN_TIME();}
		else if(param.equals("FUEL_STATUS"))
		{ret=getFUEL_STATUS();}
		else if(param.equals("date"))
		{ret=getDate();}
		else if(param.equals("time"))
		{ret=getTime();}
		else if(param.equals("FUEL_PRESSURE"))
		{ret=getFUEL_PRESSURE();}
		else if(param.equals("RELATIVE_THROTTLE_POS"))
		{ret=getRELATIVE_THROTTLE_POS();}
		else if(param.equals("THROTTLE_ACTUATOR"))
		{ret=getTHROTTLE_ACTUATOR();}
		else if(param.equals("THROTTLE_POS_B"))
		{ret=getTHROTTLE_POS_B();}
		else if(param.equals("TIMING_ADVANCE"))
		{ret=getTIMING_ADVANCE();}
		else if(param.equals("EVAPORATIVE_PURGE"))
		{ret=getEVAPORATIVE_PURGE();}
		else if(param.equals("LONG_FUEL_TRIM_2"))
		{ret=getLONG_FUEL_TRIM_2();}
		else if(param.equals("LONG_O2_TRIM_B1"))
		{ret=getLONG_O2_TRIM_B1();}
		else if(param.equals("AMBIANT_AIR_TEMP"))
		{ret=getAMBIANT_AIR_TEMP();}
		else if(param.equals("AIR_STATUS"))
		{ret=getAIR_STATUS();}
		else if(param.equals("O2_SENSORS"))
		{ret=getO2_SENSORS();}
		else if(param.equals("O2_B1S2"))
		{ret=getO2_B1S2();}
		else if(param.equals("O2_B1S1"))
		{ret=getO2_B1S1();}
		else if(param.equals("CATALYST_TEMP_B1S1"))
		{ret=getCATALYST_TEMP_B1S1();}
		else if(param.equals("BAROMETRIC_PRESSURE"))
		{ret=getBAROMETRIC_PRESSURE();}
		else if(param.equals("ACCELERATOR_POS_E"))
		{ret=getACCELERATOR_POS_E();}
		else if(param.equals("ACCELERATOR_POS_D"))
		{ret=getACCELERATOR_POS_D();}
		else if(param.equals("EGR_ERROR"))
		{ret=getEGR_ERROR();}
		else if(param.equals("OIL_TEMP"))
		{ret=getOIL_TEMP();}
		else if(param.equals("ABSOLUTE_LOAD"))
		{ret=getABSOLUTE_LOAD();}
		else if(param.equals("HYBRID_BATTERY_REMAINING"))
		{ret=getHYBRID_BATTERY_REMAINING();}
		else if(param.equals("FUEL_LEVEL"))
		{ret=getFUEL_LEVEL();}
		else if(param.equals("EVAPORATIVE_PURGE"))
		{ret=getEVAPORATIVE_PURGE();}
		else if(param.equals("WARMUPS_SINCE_DTC_CLEAR"))
		{ret=getWARMUPS_SINCE_DTC_CLEAR();}
		else if(param.equals("CONTROL_MODULE_VOLTAGE"))
		{ret=getCONTROL_MODULE_VOLTAGE();}
		else if(param.equals("STATUS_DRIVE_CYCLE"))
		{ret=getSTATUS_DRIVE_CYCLE();}
		else if(param.equals("COMMAND_EQUIV_RATIO"))
		{ret=getCOMMAND_EQUIV_RATIO();}





		return ret;
	}




	public String getRPM() {
		return RPM;
	}
	public void setRPM(String rPM) {
		RPM = rPM;
	}
	public String getSPEED() {
		return SPEED;
	}
	public void setSPEED(String sPEED) {
		SPEED = sPEED;
	}
	public String getENGINE_LOAD() {
		return ENGINE_LOAD;
	}
	public void setENGINE_LOAD(String eNGINE_LOAD) {
		ENGINE_LOAD = eNGINE_LOAD;
	}
	public String getCOOLANT_TEMP() {
		return COOLANT_TEMP;
	}
	public void setCOOLANT_TEMP(String cOOLANT_TEMP) {
		COOLANT_TEMP = cOOLANT_TEMP;
	}
	public String getSHORT_FUEL_TRIM_1() {
		return SHORT_FUEL_TRIM_1;
	}
	public void setSHORT_FUEL_TRIM_1(String sHORT_FUEL_TRIM_1) {
		SHORT_FUEL_TRIM_1 = sHORT_FUEL_TRIM_1;
	}
	public String getINTAKE_PRESSURE() {
		return INTAKE_PRESSURE;
	}
	public void setINTAKE_PRESSURE(String iNTAKE_PRESSURE) {
		INTAKE_PRESSURE = iNTAKE_PRESSURE;
	}
	public String getINTAKE_TEMP() {
		return INTAKE_TEMP;
	}
	public void setINTAKE_TEMP(String iNTAKE_TEMP) {
		INTAKE_TEMP = iNTAKE_TEMP;
	}
	public String getTHROTTLE_POS() {
		return THROTTLE_POS;
	}
	public void setTHROTTLE_POS(String tHROTTLE_POS) {
		THROTTLE_POS = tHROTTLE_POS;
	}
	public TableReading() {
		super();
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		String [] t=time.split(":");

		if(Integer.parseInt(t[0])>12)
		{
			this.time =Integer.parseInt(t[0])-12+":"+t[1]+":"+t[2]+" PM";
		}
		else
		{this.time =t[0]+":"+t[1]+":"+t[2]+" AM";}
	}

	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}


}
