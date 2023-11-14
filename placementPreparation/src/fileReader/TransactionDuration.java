package fileReader;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class TransactionDuration {
	
	/*
	 * Log file
	 * Xid     timestamp           client ID
	 * 12345, 05/15/2021 00:00:01, 10.0.0.1
	 * 12345, 05/15/2021 00:00:02, 10.0.0.2
	 * 12245, 05/15/2021 00:00:03, 10.0.0.3
	 * 234222, 05/15/2021 00:00:10, 10.0.0.1
	 * 234222, 05/15/2021 00:00:20, 10.0.0.2
	 */

	public static void main(String[] args) {
		//key = clientID
		//value = Date
		Map<String, Date> map = new HashMap<>();
		String dir = System.getProperty("user.dir") + "\\src\\fileReader\\" + "trnlog.txt";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(dir))){
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] logInfo = line.trim().split(",");
				
				if(map.containsKey(logInfo[2])) {
					SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY HH:mm:ss");
					Date endTime = format.parse(logInfo[1]);
					
					Date startTime = map.get(logInfo[2]);
					long diff = endTime.getTime() - startTime.getTime();
					
					System.out.println(logInfo[2] + "," + diff/1000);
					
					map.remove(logInfo[2]);
				}
				else {
					SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY HH:mm:ss");
					Date startTime = format.parse(logInfo[1]);
					map.put(logInfo[2], startTime);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
