package com.obdgp.utils;

public class Convertgps {

	
	public String convertDMS(double d, double m, double s)
	{String converted=null;
	double num=0;
	
	num=d+(m)/60+s/3600;
	converted=Double.toString(num);
	return converted;}
}
