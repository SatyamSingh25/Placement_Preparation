package fileReader;
import java.util.*;
import java.io.*;
public class RandomFortune {

	public static void main(String[] args) {
        List<String> fortunes = new ArrayList<>();
        String dir = System.getProperty("user.dir") + "\\src\\fileReader\\" + "randomFortune.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(dir))) {
            StringBuilder current = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.equals("%") && current.length() > 0) {
                    fortunes.add(current.toString());
                    current.setLength(0);
                } else {
                    current.append(line).append("\n");
                }
            }

            if (current.length() > 0) {
                fortunes.add(current.toString());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(fortunes.size());
        String randomFortune = fortunes.get(randomIndex);
        System.out.print(randomFortune);
	}

}
