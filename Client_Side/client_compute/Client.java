
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;


public class Client {
	public static void main(String args[]) throws IOException, ClassNotFoundException {

		Scanner scanner = new Scanner(System.in);
		// System.out.println("Type the number of prime number");
		// int scale = scanner.nextInt();

		MyRegistry myRegistry = new MyRegistry();
		Compute stub = (Compute) myRegistry.lookup("COMPUTE");
		System.out.println("Get stub---" + stub.toString());

		while (true) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("*************Compute Engine***************");
			System.out.println();
			System.out.println("       1. Pi calculation");
			System.out.println("       2. Prime number calculation");
			System.out.println();
			System.out.println("******************************************");
			System.out.println("---Please type the number to do the calculation (1 or 2)...");
			int cal = scanner.nextInt();

			switch (cal) {
			case 1:
				System.out.println("Please type the scale of Pi(after the decimal point)");
				int scale = scanner.nextInt();
				Task pi_Imp = new Pi_Imp(scale);
				BigDecimal pi_result = (BigDecimal) stub.executeTask(pi_Imp);
				System.out.println("PI is " + pi_result);
				break;
			case 2:
				System.out.println("Please type the number of Prime number");
				int num = scanner.nextInt();
				Task pImp = new Prime_Imp(num);
				String pri_result = (String) stub.executeTask(pImp);
				System.out.println("Prime numebr is " + pri_result);
				break;

			default:
				System.out.println("Not correct!");
				break;
			}
		}

	}
}
