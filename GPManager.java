package com.obdgp.Threads;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPManager {

	public static final Logger slf4jLogger = LoggerFactory.getLogger(GPManager.class);


	public static void main(String[] args) {

		slf4jLogger.info("Hello World!");


		// TODO get the offline configurations 

		ConfigLoader loader = new ConfigLoader();
		loader.start();

		// TODO start web server 
		try {
			Thread.sleep(5000); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loader.setShutdown(true);
	}

}
