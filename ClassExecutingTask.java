package com.obdgp.utils;
import java.sql.SQLException;
import java.util.Date;

import java.util.Timer;

import java.util.TimerTask;

import com.obdgp.Daos.TablereadingDao;

public class ClassExecutingTask {
	TablereadingDao tro=new TablereadingDao();
	long delay = 180*1000; // delay in milliseconds
    LoopTask task = new LoopTask();
    Timer timer = new Timer("TaskName");

    public void start() {
    timer.cancel();
    timer = new Timer("TaskName");
    Date executionDate = new Date(); // no params = now
    timer.scheduleAtFixedRate(task, executionDate, delay);
    }

    private class LoopTask extends TimerTask {
    public void run() {
        System.out.println("check danger is called every 3 mins");
        try {
			tro.getdangs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    }

}
