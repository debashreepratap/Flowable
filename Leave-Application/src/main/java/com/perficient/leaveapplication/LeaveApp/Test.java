package com.perficient.leaveapplication.LeaveApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX",Locale.ENGLISH);
    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
    	 Date fromDate = sdf.parse("2022-03-15T18:30:00.000+00:00");
    	 //Date fromDate = sdf.parse("2022-03-16T18:30:00.000+00:00");
    	// Date toDate = sdf.parse(createLeaveRequest.getToDate().toString());
   
    	 System.out.println("fromDate "+fromDate);
    	 System.out.println("formatter.format(fromDate) "+formatter.format(fromDate));
    	// System.out.println("formatter.parse(fromDate.toString()) "+formatter.parse(fromDate.toString())+"  formatter.parse(toDate.toString()) "+formatter.parse(toDate.toString()));
    	
    	 
    	 Map m= new HashMap();
    	 m.put(null, 1);
    	 m.put("debashree", 23);
    	 System.out.println(m.get(null));
    	 
    	 
	}
}
