

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.Scanner;
import org.omg.Messaging.SyncScopeHelper;


public class Client {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the scale of Pi(after the decimal point)");
		int scale = scanner.nextInt();
        
		MyRegistry myRegistry = new MyRegistry();
		
		Pi stub = (Pi)myRegistry.lookup("PI");
		System.out.println("Get stub---"+stub.toString());
		BigDecimal result = stub.execute(scale);
		System.out.println(result);

	}
}
