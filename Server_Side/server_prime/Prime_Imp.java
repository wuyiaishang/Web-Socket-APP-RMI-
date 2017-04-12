

import java.io.Serializable;
import java.math.BigDecimal;


public class Prime_Imp implements Prime, Serializable {

	@Override
	public String execute(int n) {
		// TODO Auto-generated method stub
		int i = 1;
		int num = 0;
		// Empty String
		String primeNumbers = "";
       
		while(true){
			int counter = 0;
			for (num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				// Appended the Prime number to the String
				primeNumbers = primeNumbers + i + " ";
				n--;
			}
			if(n==0){
				break;
			}
			
			i++;
		}


		return primeNumbers;
	}

}
