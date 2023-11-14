package fileReader;
import java.util.*;
import java.io.*;
public class LogParser {

	public static void main(String[] args) {
		
		TreeSet<Log> pq = new TreeSet<>();
		
		String dir = System.getProperty("user.dir") + "\\src\\fileReader\\" + "logParse.txt";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(dir))){
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] log = line.trim().split("=");
				int value = Integer.parseInt(log[1]);
				String name = log[0];
				pq.add(new Log(value, name));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Log logs: pq) {
			System.out.println(logs.toString());
		}

	}
	
	static class Log implements Comparable<Log>{
		int value;
		String name;
		Log(int val, String name){
			this.value = val;
			this.name = name;
		}
		
		@Override
		public int compareTo(Log other) {
			int result = Integer.compare(this.value, other.value);
			if(result == 0) {
				return this.name.compareTo(other.name);
			}
			return result;
		}
		
		@Override
		public String toString() {
			return name + " = " + value;
		}
	}
	
}
