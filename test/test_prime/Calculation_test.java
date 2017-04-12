package test;

import server_folder.Prime_Imp;

public class Calculation_test {
     public static void main(String[] args){
    	 Prime_Imp pImp = new Prime_Imp();
    	 String result = pImp.execute(8);
    	 System.out.println(result);
     }
}
