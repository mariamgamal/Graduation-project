package com.obdgp.Threads;



public class ConfigLoader extends Thread{
	private boolean shutdown ;
public void run(){
	while(!shutdown){
	
	try {
		sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
public boolean isShutdown() {
	return shutdown;
}
public void setShutdown(boolean shutdown) {
	this.shutdown = shutdown;
}

}
