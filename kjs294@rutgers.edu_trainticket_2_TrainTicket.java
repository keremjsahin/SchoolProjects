/*************************************************************************
 *  Compilation:  javac TrainTicket.java
 *  Execution:    java TrainTicket
 *
 *  @author: Kerem Sahin
 *
 * The program TrainTicket takes two command-line arguments: an int
 * referring to the persons age and a boolean referring to whether or
 * not the ticket was bought at the train station (true for a ticket
 * bought at the train station). The program computes and displays the
 * ticket price the person needs to pay for the train ride.
 *
 *  % java TrainTicket 23.0 true
 *  13.20
 *
 *  % java TrainTicket 23.0 false
 *  15.84
 * 
 *  % java TrainTicket 230 false
 *  Illegal input
 *
 *************************************************************************/

public class TrainTicket {

    public static void main(String[] args) {

	int age = Integer.parseInt(args[0]);
	boolean locationBought = Boolean.parseBoolean(args[1]);
	double price = 0;
	if(age < 0 || age > 120)
		System.out.println("Illegal input");
	else if(age < 7)
		{price = 0;
		System.out.println(price);}
	else
		if(locationBought == true){
			if(age > 65)
				{price = 7.5;
				System.out.println(price);}
			else
				{price = 13.20;
				System.out.println(price);}}
		else{
			if(age > 65)
				{price = 7.5 + 7.5 *.2;
				System.out.println(price);}
			else
				{price = 13.20 + 13.20 * .2;
				System.out.println(price);}}


    }

}
