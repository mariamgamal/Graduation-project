package com.obdgp.Services;

import java.sql.SQLException;
import java.util.Map;
import com.obdgp.Daos.DefinesDao;


public class DefinesService {
	
	public DefinesDao defDao = new DefinesDao();
	
	public Map<String,String> getDefinesMap() throws SQLException{
		Map<String,String>  defsMap = defDao.getDefinesFromDatabase();
		if(defsMap.isEmpty())
		{
			defsMap.put("-8000", "-8000");
		}
		return defsMap;
	}

}
