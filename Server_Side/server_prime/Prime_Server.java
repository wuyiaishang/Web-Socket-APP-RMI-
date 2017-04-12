

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;



public class Prime_Server implements Prime {
	Prime_Imp pImp = null;

	public Prime_Server(Prime_Imp pi_Imp) {
		// TODO Auto-generated constructor stub
		this.pImp = pi_Imp;
	}

	@Override
	public String execute(int digit) {
		// TODO Auto-generated method stub
		return pImp.execute(digit);
	}

	public void socketProcess(ServerSocket serverSocket) throws IOException, ClassNotFoundException {

		// listen the client request
		while (true) {
			Integer re = null;
			Socket socket = serverSocket.accept();
			System.out.println("get socket");

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			re = (Integer) ois.readObject();

			// calculating
			String result = execute(re);
			System.out.println("server result----" + result);
			oos.writeObject(result);

			// close socket
			oos.close();
			socket.close();

		}
	}

}
