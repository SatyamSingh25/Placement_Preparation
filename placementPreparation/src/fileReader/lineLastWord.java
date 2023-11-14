package fileReader;

import java.io.*;
import java.util.*;

public class lineLastWord {

	public static void main(String[] args) {
	     String dir = "C:\\Users\\Satyam\\OneDrive\\Desktop\\test.txt";
	     System.out.println(dir);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(dir))){
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] words = line.trim().split(" ");
				
				if(words.length > 0) {
					String lastWord = words[words.length-1];
					System.out.println(lastWord);
				}
				else {
					System.out.println("line is empty");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
