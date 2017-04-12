
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;

public class Prime_Client implements Prime, Serializable {

	int portNum;
	String ipAddress;
	int argDigit;

	@Override
	public String toString() {
		return "Prime_Client [portNum=" + portNum + ", ipAddress=" + ipAddress + ", argDigit=" + argDigit + "]";
	}

	@Override
	public String execute(int digit) {
		// TODO Auto-generated method stub

		// add socket code over here
		this.argDigit = digit;

		try {
			return getResult();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Prime_Client() {

	}

	public Prime_Client(int port, String ip) {
		this.portNum = port;
		this.ipAddress = ip;
	}

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

	public String getResult() throws UnknownHostException, IOException, ClassNotFoundException {
		String inline;
		String re = null;

		Socket cSocket = new Socket(ipAddress, portNum);
		ObjectOutputStream oos = new ObjectOutputStream(cSocket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(cSocket.getInputStream());

		oos.writeObject(new Integer(argDigit));
		re = (String) ois.readObject();

		return re;
	}

}
