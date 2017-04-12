package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;

import Interface_folder.Pi;
import rmi_library.MyRegistry;

public class ObjectClient {
	public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException {

		MyRegistry myRegistry = new MyRegistry();
		Pi pi = (Pi) myRegistry.lookup("PI");
		BigDecimal result = pi.execute(3);
        System.out.println(result);
	}
}
