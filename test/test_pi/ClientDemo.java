package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	public static void main(String args[]) throws UnknownHostException, IOException {
		String hostname = "127.0.0.1";
		int port = 11111;
		String inline = "";
		Socket cSocket = new Socket(hostname, port);
		PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
		out.println("hello from client");
		while((inline=in.readLine())!=null){
			System.out.println(inline);
			if(inline.equals("ack from server")){
				break;
			}
		}
		System.out.println("client done");
		/*
		 * String hostName = args[0]; int portNumber =
		 * Integer.parseInt(args[1]);
		 * 
		 * try ( Socket echoSocket = new Socket(hostName, portNumber);
		 * PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),
		 * true); BufferedReader in = new BufferedReader( new
		 * InputStreamReader(echoSocket.getInputStream()));
		 * 
		 * )catch (Exception e) { // TODO: handle exception }
		 */
	}
}
