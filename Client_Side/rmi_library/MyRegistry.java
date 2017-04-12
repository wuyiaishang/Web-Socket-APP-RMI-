


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class MyRegistry {
	/*
	 * Class MyRegistry.java should implement rebind and lookup methods
	 */
	String ipAddress = "127.0.0.1";
	int cport = 11111;
	int sport = 11122;
	
	public  void rebind(String refname, Object reference) throws UnknownHostException, IOException {
		Socket socket = new Socket(ipAddress, sport);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		oos.writeObject(new String(refname));
		oos.writeObject(reference);
		
	}

	public  Object lookup(String refname) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket(ipAddress, cport);
		Object object;
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        oos.writeObject(new String(refname));
        object = ois.readObject();
        return object;
	}

}
