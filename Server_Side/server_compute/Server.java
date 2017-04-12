

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;


public class Server {
    
	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, UnknownHostException, IOException{
  	
		// register pi service
		 ComputeEngine cEngine = new ComputeEngine();
		
		 ComputeStub stub = (ComputeStub) MyUnicast.exportObject(cEngine, "ComputeStub", "Compute_Server");
		
		System.out.println(stub.toString());
    	MyRegistry myRegistry = new MyRegistry();
    	myRegistry.rebind("COMPUTE", stub);

    	
    }
	
	
	
}
