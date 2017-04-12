

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class ComputeStub implements Compute, Serializable{

	int portNum;
	String ipAddress;
	Task task;
	
	public ComputeStub(int port, String ip){
		this.portNum = port;
		this.ipAddress = ip;
	}
	
	public ComputeStub(){}
	
	public int getPortNum() {
		return portNum;
	}

	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public Object executeTask(Task task) {
		// TODO Auto-generated method stub
		this.task = task;
		try {
			return getResult();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Object getResult() throws UnknownHostException, IOException, ClassNotFoundException {
		String inline;
		Object re = null;

		Socket cSocket = new Socket(ipAddress, portNum);
		ObjectOutputStream oos = new ObjectOutputStream(cSocket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(cSocket.getInputStream());

		oos.writeObject(task);
		re = ois.readObject();

		return re;
	}

	@Override
	public String toString() {
		return "ComputeEngine [portNum=" + portNum + ", ipAddress=" + ipAddress + ", task=" + task + "]";
	}


}
