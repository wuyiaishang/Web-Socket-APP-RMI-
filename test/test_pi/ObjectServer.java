package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Interface_folder.Pi;
import server_folder.Pi_Imp;

public class ObjectServer {
     public static void main(String args[]) throws IOException, ClassNotFoundException{
    	 int port = 11111;
 		ServerSocket sSocket = new ServerSocket(port);
 		while(true){
 			Socket cSocket = sSocket.accept();
 			OutputStream os = cSocket.getOutputStream();
 			InputStream is = cSocket.getInputStream();
 			
 			ObjectOutputStream obos = new ObjectOutputStream(os);
 			ObjectInputStream obis = new ObjectInputStream(is);
 			BufferedReader bReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
 			Integer scale = (Integer)obis.readObject();
 			String re=null;

 			Pi_Imp pi_Imp = new Pi_Imp(scale);
 			
 			obos.writeObject(pi_Imp);
 			//obos.writeObject(new String("another object from the client"));
 			obos.close();
 			os.close();
 			cSocket.close();
 	        
 			System.out.println("server done!");	
 		}
 		
     }
}
