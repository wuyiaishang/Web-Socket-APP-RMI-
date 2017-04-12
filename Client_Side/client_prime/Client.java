

import java.io.IOException;
import java.util.Scanner;


public class Client {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the number of prime number");
		int scale = scanner.nextInt();
        
		MyRegistry myRegistry = new MyRegistry();
		
		Prime stub = (Prime)myRegistry.lookup("PRIME");
		System.out.println("Get stub---"+stub.toString());
		String result = stub.execute(scale);
		System.out.println(result);

	}
}
