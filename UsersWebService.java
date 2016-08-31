package com.obdgp.webservices;



import com.obdgp.Services.ReadingService;
import com.obdgp.Services.UsersService;
import com.obdgp.utils.SplitRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsersWebService implements ErrorController {
		
	
	public class User{public String Username;public String Password;User(){}}
	
	private UsersService us;
	private SplitRequest sr;
	
	@RequestMapping(value = "/ValidateUser", method = RequestMethod.POST, 
			headers = "content-type=application/json")//consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"},headers = "content-type=application/x-www-form-urlencoded"
    public List<String> UserValidation(@RequestBody(required=false) String body) {
		
		sr = new SplitRequest();
		
		String[] bodySplit = sr.SplitRequestBody(body);
		String _username = bodySplit[0];
		String _pass = bodySplit[1];
		
        System.out.println("*************************Users Web Service,"
        		+ " trying to Validate user.*************************");
    	String retVal = null;
    	us = new UsersService();
    	try {
			retVal = us.getUserID(_username,_pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	List<String> retString = new ArrayList<String>();
    	if(retVal.equals("notf"))
    		retString.add("failure");
    	else
    		retString.add("success");
    	
    	return retString;
    	
	}

	

	@RequestMapping(value = "/error")
	public String error() {
		return "Error handling";
	}
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
/////////////////Changepassword
	
@RequestMapping(value = "/changepassword" , method = RequestMethod.POST) // , method = RequestMethod.GET
public @ResponseBody String[] Changepass(@RequestBody(required = false)String input) {
System.out.println("*************************Users Web Service/changing userpassword*************************");
String [] dataArray=input.split(",");
String[] ret=null;
ret = new String[1];
us = new UsersService();
try {	
ret[0]=us.Changepassword(dataArray[0], dataArray[1], dataArray[2]);

} catch (Exception e) {
// TODO Auto-generated catch block
System.out.println(e.getMessage());
e.printStackTrace();
}

return ret;
}
/////////passwordreset



@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
@ResponseBody
public String[] resetPassword(
		 @RequestBody(required = false)String email)  {
     String [] msg=null;
     msg=new String[1];
	us = new UsersService();
	
	try {
	msg[0]=us.resetpassword(email);
 
}catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	e.printStackTrace();
	}
System.out.println(msg);
  return msg;
}

}
