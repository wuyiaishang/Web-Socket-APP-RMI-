
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;

import javax.security.auth.Subject;



public class Server {
    
	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, UnknownHostException, IOException{
  	
		// register pi service
		Pi_Imp pi = new Pi_Imp();
		

		Pi_Client stub = (Pi_Client) MyUnicast.exportObject(pi, "Pi_Client", "Pi_Server");
		
		System.out.println(stub.toString());
    	MyRegistry myRegistry = new MyRegistry();
    	myRegistry.rebind("PI", stub);

    	
    }
	
	
	
}
