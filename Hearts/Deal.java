package hearts;

import java.io.IOException;

import io.IO;

/**
 * Deal.java is a class that takes in a string representation
 * of a 52 card CardGroup and calls the deal() method of the CardGroup class,
 * which creates 4 'hands' (i.e. 13 card CardGroups) and prints the string
 * representation of those hands
 * 
 * @author Adam Sachs, ajs2255
 */
public class Deal {
	
	/**
	 * main class that runs the program
	 */
	public static void main(String args[]){
		//this is where the parsedCG will be stored
		CardGroup deck = null;
		try {
			deck = CardGroup.parseCG(IO.stdin.readLine());
		} catch (IOException e) {
			IO.stderr.println("Cannot deal this input.");
		}
		IO.stdout.println(deck.deal());
	}
}

