

import java.io.Serializable;
import java.math.BigDecimal;


public class Prime_Imp implements Task, Serializable {
	
	int n;
	
	public Prime_Imp( int n ) {
		// TODO Auto-generated constructor stub
		this.n = n;
	}
	

	@Override
	public String execute() {
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
