


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;


public class MyUnicast {
	/*
	 * Class MyUnicast.java is responsible for assigning anonymous port numbers
	 * for exporting remote objects to listen to incoming calls. Class
	 * MyUnicast.java is responsible for creating new threads to listen to
	 * incoming calls.
	 */
	static int pNum = 11222;
	final static String ipAddress = "127.0.0.1";

	public static Object exportObject(Object obj, String cName, String lisName)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// "server_folder.Pi_Client"
		Class<?> c = Class.forName(cName);
		Constructor<?> cons = c.getConstructor(int.class, String.class);
		Object cobject = cons.newInstance(pNum, ipAddress);

		// create calculation class
		Class<?> lis = Class.forName(lisName);

		// need change...
		Constructor<?> lcons = lis.getConstructor(obj.getClass());

		Object lobject = lcons.newInstance(obj);
		Method method = lis.getDeclaredMethod("socketProcess", ServerSocket.class);

		// create thread to listen the port
		new Thread() {
			public void run() {

				ServerSocket serverSocket = null;
				Socket socket = null;
				try {
					serverSocket = new ServerSocket(pNum);
					System.out.println("listening the port"+pNum);
					pNum++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					method.invoke(lobject, serverSocket);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		}.start();

		

		return cobject;

	}

}
