package test;


import java.util.LinkedHashMap;
import java.util.List;

public class test {

	public static void main(String[] args) throws Exception {
		
		LinkedHashMap<Integer, List<String>> dataMap = ReadExcel.getMapData();
		dataMap.remove(0);
		
		for (List value : dataMap.values()) {
		  
		  String companyName = value.get(0).toString();
		  String email = value.get(1).toString();
		  
		  System.out.println("cName: " + companyName + "  " + "email: "+ email);
		  
		  SendMailSSL.send(companyName, email);
		}
	;
	}
}
 