package com.obdgp.utils;

import com.mysql.jdbc.StringUtils;

public class SplitRequest {

	public SplitRequest(){}

	public String[] SplitRequestBody(String body)
	{
		String[] bodySplit = body.split(",");
		String _username = bodySplit[0].split(":")[1].replace("\"", "");
		String _pass = bodySplit[1].split(":")[1].replace("\"", "").replace("}", "");
		String[] retString = {_username,_pass};
		return retString;
	}

	public String splitString(String body)
	{String ret=null;
	if(StringUtils.isNullOrEmpty(body))
	{
		ret="0";}
	else if(body.equals("NoneNone"))
	{
		ret="0";}
	
	else if(body.equals("nonenone"))
	{
		ret="0";}
	else
	{
		String r=body.replaceAll("None", ""); 
		String a=r.replaceAll("%", "");
		String [] part =a.split("(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)");
		ret=part[0];
	}
	return ret;
	}


}
