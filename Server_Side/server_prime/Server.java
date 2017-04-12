

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;


public class Server {
    
	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, UnknownHostException, IOException{
  	
		// register pi service
		Prime_Imp pi = new Prime_Imp();
		
		 Prime_Client stub = (Prime_Client) MyUnicast.exportObject(pi, "Prime_Client", "Prime_Server");
		
		System.out.println(stub.toString());
    	MyRegistry myRegistry = new MyRegistry();
    	myRegistry.rebind("PRIME", stub);

    	
    }
	
	
	
}
