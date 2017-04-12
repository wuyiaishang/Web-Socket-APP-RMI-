
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;



public class MyStartRegistry {
	/*
	 * java StartRegistry can be used to start the registry process to listen at
	 * a specific port 11111
	 */
	public static void main(String args[]) throws IOException, ClassNotFoundException {

		String ref;
		int cport = 11111;
		int sport = 11122;

		HashMap<String, Object> registry = new HashMap<>();

		// listen message from client
		ServerSocket client_ServerSocket = new ServerSocket(cport);


		// run service register thread

		// add loop to listen

		new Thread() {
			public void run() {

				String sref = null;
				Socket sSocket = null;
				OutputStream os = null;
				InputStream is = null;
				// listen message from server for register service
				ServerSocket server_ServerSocket = null;
				try {
					server_ServerSocket = new ServerSocket(sport);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					sSocket = server_ServerSocket.accept();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					os = sSocket.getOutputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					is = sSocket.getInputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					ObjectOutputStream obos = new ObjectOutputStream(os);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ObjectInputStream obis = null;
				try {
					obis = new ObjectInputStream(is);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// get reference name
				try {
					sref = (String) obis.readObject();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// get stub
				Object object = null;
				try {
					object = (Object) obis.readObject();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				registry.put(sref, object);
				System.out.println("Register the " + sref + "---" + object.toString());

			}
		}.start();


		// listen the requests from client
		while (true) {
			Socket cSocket = client_ServerSocket.accept();
			ObjectInputStream ois = new ObjectInputStream(cSocket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(cSocket.getOutputStream());
            System.out.println("listen client request");
			// get reference name from client
			ref = (String) ois.readObject();
			System.out.println("search Registry and return object----" + ref);
			oos.writeObject(registry.get(ref));
			System.out.println(registry.get(ref).toString());
			ois.close();
			oos.close();
			cSocket.close();

		}

	}
}
