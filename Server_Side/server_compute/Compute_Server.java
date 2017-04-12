

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Compute_Server implements Compute {
    
	ComputeEngine cEngine = null;
	
	public Compute_Server(ComputeEngine cEngine) {
		// TODO Auto-generated constructor stub
		this.cEngine = cEngine;
	}
	
	@Override
	public Object executeTask(Task task) {
		// TODO Auto-generated method stub
		return cEngine.executeTask(task);
	}
	
	public void socketProcess(ServerSocket serverSocket) throws IOException, ClassNotFoundException {

		// listen the client request
		while (true) {
			Task task = null;
			Socket socket = serverSocket.accept();
			System.out.println("get socket");

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			task = (Task) ois.readObject();

			// calculating
			Object result = executeTask(task);
			System.out.println("server result----" + result);
			oos.writeObject(result);

			// close socket
			oos.close();
			socket.close();

		}
	}
	

}
