/*************************************************************************
 *  Compilation:  javac Gas.java
 *  Execution:    java Gas 3.40 15.0 true
 *
 *  @author: Kerem Sahin
 *
 * The program Gas computes and displays the price a
 * person will pay for gas at the gas station.
 *
 *  % java Gas 3.40 15.0 false
 *  56.1
 *
 *  % java Gas 3.40 15.0 true
 *  51.0
 *
 *************************************************************************/

public class Gas {

    public static void main(String[] args) {
    	double pricePerGallon = Double.parseDouble(args[0]);
    	double numOfGallons = Double.parseDouble(args[1]);
    	Boolean cashOrCredit = Boolean.parseBoolean(args[2]);
    	double price = numOfGallons * pricePerGallon;

    	if(pricePerGallon <= 0 || numOfGallons <= 0)
    		System.out.println("Illegal input");
    	else if(cashOrCredit == true)
    		System.out.println(price);
    	else{
    		price += price * .1;
    		System.out.println(price);
    	}
	
    }
}
