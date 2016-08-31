package com.obdgp.webservices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.obdgp.Services.DefinesService;
import com.obdgp.Services.ReadingService;

@RestController
public class TablereadingWebService {


	private ReadingService rs;

	public class data{String dataname;String datavalue;public data(){};}
	@RequestMapping(value = "/AllReadings",method = RequestMethod.POST/*,headers = "content-type=application/json"*/) 
	public @ResponseBody List<String> getAllReadings(@RequestBody(required = false)String id) {
		// TODO: Agree on function's input parameters

		List<data> ld = new ArrayList<data>();
	
		List<String> readingIDs = null;
		rs = new ReadingService();
		try {
			readingIDs = rs.getTblreading(id);	
			String checkString = readingIDs.get(0);
			data d = new data();
			for(int i=0 ; i<readingIDs.size() ; i++)
			{
				d.dataname = "reading"+i;
				d.datavalue = readingIDs.get(i).split("=")[1];
				ld.add(d);
			
			}

			if(checkString == "No Readings found!!!") // the list is empty
			{
				readingIDs.clear();
				readingIDs.add("No Readings found!!!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}



		return readingIDs;
	}




	@RequestMapping(value = "/ImportantReadings" ,method = RequestMethod.POST/*,headers = "content-type=application/json"*/) 
	public @ResponseBody List<String> getIMPReadings(@RequestBody(required = false)String id) {
		// TODO: Agree on function's input parameters

		List<data> ld = new ArrayList<data>();
		
		List<String> readingIDs = null;
		rs = new ReadingService();
		try {
			readingIDs = rs.getImportantReadings(id);	
			String checkString = readingIDs.get(0);
			data d = new data();
			for(int i=0 ; i<readingIDs.size() ; i++)
			{
				d.dataname = "reading"+i;
				d.datavalue = readingIDs.get(i).split("=")[1];
				ld.add(d);
				
			}

			if(checkString == "NO Important Readings found!!!") // the list is empty
			{
				readingIDs.clear();
				readingIDs.add("NO Important Readings found!!!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


		return readingIDs;
	}

	@RequestMapping(value = "/SelectedReadings" ,method = RequestMethod.POST/*,headers = "content-type=application/json"*/) 
	public @ResponseBody List<String> getSelectReadings(@RequestBody(required = false)String input) {
		// TODO: Agree on function's input parameters

		String[] dataArray =input.split(",");
		List<data> ld = new ArrayList<data>();
		System.out.println("The device name is: "+dataArray[0]);
	
		List<String> readingIDs = null;
		rs = new ReadingService();
		try {
			readingIDs = rs.getSelectReadings(dataArray[0],dataArray[1]);	
			String checkString = readingIDs.get(0);
			data d = new data();
			for(int i=0 ; i<readingIDs.size() ; i++)
			{
				d.dataname = "reading"+i;
				d.datavalue = readingIDs.get(i).split("=")[1];
				ld.add(d);
				
			}

			if(checkString == "NO Important Readings found!!!") // the list is empty
			{
				readingIDs.clear();
				readingIDs.add("NO Important Readings found!!!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}



		return readingIDs;
	}

	/////////////InsertPi
	@RequestMapping(value = "/InsertPi" , method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody void insertReading(@RequestBody(required = false)String id) {
		System.out.println("*************************TableReadings Web Service/Inserting Readings from Pi*************************");

		
		rs = new ReadingService();
		try {
			rs.Insertdata(id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}






	////////////////////Data for charts

	@RequestMapping(value = "/Chartcomp" , method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody String[][] Chartcomp(@RequestBody(required = false)String input) {
		System.out.println("*************************TableReadings Web Service/chart comparison *************************");
		
		String [] dataArray =input.split("/");
		String [] dev=dataArray[3].split(",");
		String [][] output = null;
		String [][][] dummy = null;

		try {
			if(dataArray[0].equals("Annually")){
				

				String [] yfrom=dataArray[1].split("-");
				String [] yto=dataArray[2].split("-");
				String[] paramArray =dataArray[3].split(",");
				int size;
				int size2;

				size2=(Integer.parseInt(yfrom[0])-Integer.parseInt(yto[0])+2);
				size=paramArray.length;

				output = new String[size2][size+1];

				dummy=new String[size+1][size2][2];
				for(int i=0;i<dev.length;i++)
				{dummy[i]=getych(dataArray[0]+"/"+dataArray[1]+"/"+dataArray[2]+"/"+dev[i]+"/"+dataArray[4]);
				output[0][i+1]=dev[i];
				dummy[i][0][1]=dev[i];


				}

				output[0][0]=dummy[0][0][0];

				for(int i=1; i<size2;i++)
					for(int j=0;j<size;j++)
					{{
						int k=j-1;
						output[i][0]=dummy[0][i][0];
						output[i][j+1]=dummy[j][i][1];



					}}
				System.out.println("===========================output comp===================================");
				for(int i=0 ; i<size2 ; i++)
				{
					for(int j=0 ; j<size+1 ; j++)
						System.out.println(output[i][j]);
				}
				System.out.println("output***"+output[0][0]+"**"+output[0][1]+"**"+output[0][2]+"**"+output[1][1]+"**"+output[1][2]);


			}
			else if(dataArray[0].equals("monthly"))
			{

				String dum1=null;
				String dum2=null;
				String [] yfrom=dataArray[1].split("-");
				String [] yto=dataArray[2].split("-");
				String[] paramArray =dataArray[3].split(",");
				int size;
				int size2;
				Date dt1 = new Date (Integer.parseInt(yfrom[0]), Integer.parseInt(yfrom[1]),1,0,0,0);
				Date dt2 = new Date(Integer.parseInt(yto[0]), Integer.parseInt(yto[1]), 1,0,0,0);
				double mnthcount = (dt1.getTime()-dt2.getTime())/ ( 365.24 * 24 * 60 * 60 * 1000 / 12);

				if(yfrom[0]!=yto[0])
				{

					size2=(int) Math.ceil(mnthcount)+2;


				}
				else
				{size2=(Integer.parseInt(yto[1])-Integer.parseInt(yfrom[1]))+3;

				}
				size=paramArray.length;
				output = new String[size2][size+1];

				dummy=new String[size+1][size2][2];
				for(int i=0;i<dev.length;i++)
				{dummy[i]=getych(dataArray[0]+"/"+dataArray[1]+"/"+dataArray[2]+"/"+dev[i]+"/"+dataArray[4]);
				output[0][i+1]=dev[i];
				dummy[i][0][1]=dev[i];


				}
				for(int l=0;l<dev.length;l++)
				{	dum1=dummy[l][size2-2][0];
				System.out.println("dum1"+dummy[l][size2-2][0]);
				dum2=yfrom[1]+"-"+yfrom[0];
				System.out.println("dum2"+yfrom[1]+"-"+yfrom[0]);

				if(dum1.equals(dum2))
				{
					output = new String[size2-1][size+1];
					output[0][0]=dummy[0][0][0];
					for(int i=0;i<dev.length;i++)
					{
						output[0][i+1]=dev[i];}
					for(int i=1; i<size2-1;i++)
						for(int j=0;j<size;j++)
						{{
							int k=j-1;
							output[i][0]=dummy[0][i][0];
							output[i][j+1]=dummy[j][i][1];



						}}

				}
				else
				{ 
					output = new String[size2][size+1];
					output[0][0]=dummy[0][0][0];
					for(int i=0;i<size2;i++)
					{for(int j=0;j<size;j++)
					{

						output[i][0]=dummy[0][i][0];
						output[i][j+1]=dummy[j][i][1];
					}
					}
				}
				}

			}


			else if(dataArray[0].equals("daily"))
			{
				String[] paramArray =dataArray[3].split(",");
				int size;
				int size2;
				long daycount;
				String [] date1=dataArray[1].split("-");
				String [] date2=dataArray[2].split("-");
				Date dt1 = new Date (Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(date1[2]),0,0,0);
				Date dt2 = new Date(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(date2[2]),0,0,0);

				daycount=(dt1.getTime()-dt2.getTime())/ (1000 * 60 * 60 * 24);
				size2=(int)daycount+3;
				size=paramArray.length;
				output = new String[size2][size+1];

				dummy=new String[size+1][size2][2];
				for(int i=0;i<dev.length;i++)
				{dummy[i]=getych(dataArray[0]+"/"+dataArray[1]+"/"+dataArray[2]+"/"+dev[i]+"/"+dataArray[4]);
				output[0][i+1]=dev[i];
				dummy[i][0][1]=dev[i];


				}

				output[0][0]=dummy[0][0][0];

				for(int i=1; i<size2;i++)
					for(int j=0;j<size;j++)
					{{

						output[i][0]=dummy[0][i][0];
						output[i][j+1]=dummy[j][i][1];



					}}






			}

			else if(dataArray[0].equals("hourly"))
			{
				String[] paramArray =dataArray[3].split(",");
				int size;
				int size2=25;
				size=paramArray.length;
				output = new String[size2][size+1];

				dummy=new String[size+1][size2][2];
				for(int i=0;i<dev.length;i++)
				{dummy[i]=getych(dataArray[0]+"/"+dataArray[1]+"/"+dataArray[2]+"/"+dev[i]+"/"+dataArray[4]);
				output[0][i+1]=dev[i];
				dummy[i][0][1]=dev[i];


				}

				output[0][0]=dummy[0][0][0];

				for(int i=1; i<size2;i++)
					for(int j=0;j<size;j++)
					{{

						output[i][0]=dummy[0][i][0];
						output[i][j+1]=dummy[j][i][1];



					}}

			}



		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


		return output;
	}




	@RequestMapping(value = "/Chart" , method = RequestMethod.POST)
	public @ResponseBody String[][] getych(@RequestBody(required = false)String input) //,@RequestBody(required = false)String y1,@RequestBody(required = false)String y2,@RequestBody(required = false)String param,@RequestBody(required = false)String interval
	{
		System.out.println("*************************TableReadings Web Service/charts*************************");
		

		String[] dataArray =input.split("/");
		String[][] output = null;
		String[][] dummy = null;
		rs = new ReadingService();
		try { 

			if(dataArray[0].equals("Annually")){

				String [] yfrom=dataArray[1].split("-");
				String [] yto=dataArray[2].split("-");
				String[] paramArray =dataArray[4].split(",");
				int size;
				int size2;

				size2=(Integer.parseInt(yfrom[0])-Integer.parseInt(yto[0])+2);
				size=paramArray.length;

				output = new String[size2][size+1];
				output=rs.getyearlyd(yfrom[0],yto[0],dataArray[3],dataArray[4],size,size2);

				if(output[0][0]==null ) // the list is empty
				{
					output[0][0]="No Important Readings Found";
				}
				
			}
			else if(dataArray[0].equals("monthly"))
			{

				String dum1=null;
				String dum2=null;
				String [] yfrom=dataArray[1].split("-");
				String [] yto=dataArray[2].split("-");
				String[] paramArray =dataArray[4].split(",");
				int size;
				int size2;
				Date dt1 = new Date (Integer.parseInt(yfrom[0]), Integer.parseInt(yfrom[1]),1,0,0,0);
				Date dt2 = new Date(Integer.parseInt(yto[0]), Integer.parseInt(yto[1]), 1,0,0,0);
				double mnthcount = (dt1.getTime()-dt2.getTime())/ ( 365.24 * 24 * 60 * 60 * 1000 / 12);

				if(yfrom[0]!=yto[0])
				{

					size2=(int) Math.ceil(mnthcount)+2;


				}
				else
				{size2=(Integer.parseInt(yto[1])-Integer.parseInt(yfrom[1]))+3;

				}
				size=paramArray.length;
				dummy=new String[size2][size+1];


				dummy=rs.getMonthlyd(yfrom[0]+"-"+yfrom[1]+"-01",yto[0]+"-"+yto[1]+"-01",dataArray[3],dataArray[4],size,size2);



				dum1="0"+dummy[size2-1][0];


				if(dum1.equals("011"+"-"+yfrom[0]))
				{
					dum1="11"+"-"+yfrom[0];

				}
				else if(dum1.equals("012"+"-"+yfrom[0]))
				{


					dum1="12"+"-"+yfrom[0];

				}
				else if(dum1.equals("010"+"-"+yfrom[0]))
				{
					dum1="10"+"-"+yfrom[0];

				}
				else
				{dum1=dum1;

				}
				dum2=yfrom[1]+"-"+yfrom[0];

				if(dummy[0][0]==null ) 
				{
					output[0][0]="No Important Readings Found";
				}
				else if(dum1.equals(dum2))
				{
					output = new String[size2][size+1];
					output=dummy;

				}
				else
				{ 
					output = new String[size2-1][size+1];
					for(int i=0;i<size2-1;i++)
					{for(int j=0;j<size+1;j++)
					{

						output[i][j]=dummy[i][j];
					}
					}
				}

			}
			else if(dataArray[0].equals("daily"))
			{
				String[] paramArray =dataArray[4].split(",");
				int size;
				int size2;
				long daycount;
				String [] date1=dataArray[1].split("-");
				String [] date2=dataArray[2].split("-");
				Date dt1 = new Date (Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(date1[2]),0,0,0);
				Date dt2 = new Date(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(date2[2]),0,0,0);

				daycount=(dt1.getTime()-dt2.getTime())/ (1000 * 60 * 60 * 24);
				size2=(int)daycount+3;
				size=paramArray.length;
				output = new String[size2-1][size+1];

				output=rs.getDailyd(dataArray[1],dataArray[2],dataArray[3],dataArray[4],size,size2);

				if(output[0][0]==null ) // the list is empty
				{
					output[0][0]="No Important Readings Found";
				}

				

			}

			else if(dataArray[0].equals("hourly"))
			{
				String[] paramArray =dataArray[4].split(",");
				int size;
				int size2=25;
				size=paramArray.length;
				output = new String[size2][size+1];
				output=rs.gethourlyd(dataArray[1], dataArray[3], dataArray[4], size);

				if(output[0][0]==null ) // the list is empty
				{
					output[0][0]="No Important Readings Found";
				}

			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return output;
	}



	///////Get location
	@RequestMapping(value = "/GetLocation") // , method = RequestMethod.GET
	public @ResponseBody String[] Getlocation(@RequestBody(required = false)String input) throws SQLException 
	{
		
		String[] dataArray =input.split(",");
		String [] readings=new String[4];
		rs=new ReadingService();
		readings=rs.getLocation(dataArray[0], dataArray[1]);

		

		return readings;


	}

	///

	@RequestMapping(value = "/Sendmessage", method = RequestMethod.POST) // , method = RequestMethod.GET
	public @ResponseBody String[] Sendmessage() throws SQLException 
	{

		
		String[] readings=new String[1];
		rs=new ReadingService();
		readings[0]=rs.Sendmessage();

		return readings;


	}

	@RequestMapping(value = "/Getdangerousness") // , method = RequestMethod.GET
	public @ResponseBody String[] GetD(@RequestBody(required = false)String input) throws SQLException 
	{

		String[] readings=null;
		rs=new ReadingService();
		readings=rs.getdangerousness(input);


		return readings;


	}


}
