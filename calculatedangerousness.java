package com.obdgp.utils;

import com.mysql.jdbc.StringUtils;

public class calculatedangerousness {




	public String getdangerousness(String d, String m)
	{String dangerousness=null;
	
	 if(!StringUtils.isNullOrEmpty(m)&&!m.equals("NoneNone")&& !m.equals("nonenone") )
	 {//System.out.println("%%%%%");
		 m=m;}
	 else{
		 System.out.println(m+"is null");
		 m="0";
	}
	double value=Double.parseDouble(m);

	if(d.equals("SPEED"))
	{if(value>120 && value<180)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>180){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("RPM"))
	{if(value>4000 && value<5000)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>2000){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("ENGINE_LOAD"))
	{if(value>65 && value<80)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>80){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("COOLANT_TEMP"))
	{if(value>95 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("SHORT_FUEL_TRIM_1"))
	{if(value>75 && value<90)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>90){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("INTAKE_PRESSURE"))
	{if(value>48 && value<60)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>60){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("INTAKE_TEMP"))
	{if(value>95 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("THROTTLE_POS"))
	{if(value>55 && value<70)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>70){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("DISTANCE_SINCE_DTC_CLEAR"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("DISTANCE_W_MIL"))
	{if(value>99000 && value<100000)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100000){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("RUN_TIME"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("FUEL_STATUS"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("FUEL_PRESSURE"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("RELATIVE_THROTTLE_POS"))
	{if(value>60 && value<70)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>70){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("THROTTLE_ACTUATOR"))
	{if(value>60 && value<70)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>70){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("THROTTLE_POS_B"))
	{if(value>60 && value<70)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>70){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("TIMING_ADVANCE"))
	{if(value>165 && value<180)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>180){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("EVAPORATIVE_PURGE"))
	{if(value>80 && value<90)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>90){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("LONG_FUEL_TRIM_2"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("LONG_O2_TRIM_B1"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("AMBIANT_AIR_TEMP"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("AIR_STATUS"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("O2_SENSORS"))
	{if(value>0.5 && value<1)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>1){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("O2_B1S2"))
	{if(value>0.72 && value<1)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>1){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("O2_B1S1"))
	{if(value>0.72 && value<1)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>1){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("CATALYST_TEMP_B1S1"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("BAROMETRIC_PRESSURE"))
	{if(value>180 && value<200)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>200){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("ACCELERATOR_POS_E"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("ACCELERATOR_POS_D"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("EGR_ERROR"))
	{if(value>35 && value<50)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>50){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("OIL_TEMP"))
	{if(value>90 && value<110)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>110){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("ABSOLUTE_LOAD"))
	{if(value>45 && value<60)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>60){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("HYBRID_BATTERY_REMAINING"))
	{if(value>10 && value<12)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>12){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("FUEL_LEVEL"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}

	else if(d.equals("WARMUPS_SINCE_DTC_CLEAR"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("CONTROL_MODULE_VOLTAGE"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("STATUS_DRIVE_CYCLE"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}
	else if(d.equals("COMMAND_EQUIV_RATIO"))
	{if(value>50 && value<100)
	{
		dangerousness="critical"+","+d+","+m;

	}
	else if(value>100){
		dangerousness="dangerous"+","+d+","+m;}
	else
		dangerousness="normal"+","+d+","+m;}

	
	
	return dangerousness;
	}

}
