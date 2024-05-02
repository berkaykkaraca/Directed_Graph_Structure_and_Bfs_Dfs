import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);
		  Digraph cityGraph = new Digraph(1000);
		  System.out.print("Enter the file name: ");
	        String fileName = scanner.nextLine();

	        System.out.print("Enter the number of hops: ");
	        int hops = scanner.nextInt();

	        System.out.print("Enter the source city: ");
	        String source = scanner.next();
	        String[] cities = new String[1000]; // Assuming a maximum of 1000 cities, adjust as needed
	        int cityCount = 0;

	        try (BufferedReader br = new BufferedReader(new FileReader("src/"+fileName))) {
	        	String line;
	            while ((line = br.readLine()) != null) {
	                String[] cityPair = line.split(",");
	                if (cityPair.length == 2) {
	                    String sourceCity = cityPair[0].trim();
	                    String destinationCity = cityPair[1].trim();
	                    cityGraph.addEdge(sourceCity, destinationCity);
	                } else {
	                    System.out.println("Invalid line: " + line);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Print the graph
	        System.out.println("City Graph:");
	        cityGraph.findRoutes(source, hops);
	     }
	    


	    private static boolean containsCity(String[] cities, int cityCount, String city) {
	        for (int i = 0; i < cityCount; i++) {
	            if (cities[i] != null && cities[i].equals(city)) {
	                return true;
	            }
	        }
	        return false;
	    

	        
	}
}
