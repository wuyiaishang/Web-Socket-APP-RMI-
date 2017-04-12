package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String args[]) throws IOException {
		int port = 11111;
		String outString = "";
		ServerSocket sSocket = new ServerSocket(port);
		while(true){
			Socket cSocket = sSocket.accept();
			PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
	        while ((outString=in.readLine())!=null) {
				System.out.println(outString);
				out.println("ack from server");

			}
	        
			System.out.println("server done!");	
		}
		
	}
}
