package hearts;

import java.io.IOException;

import io.IO;


/**
 * Shuffle.java is a class that takes a 52 card CardGroup as input
 * and then calls the shuffle() method of the CardGroup class,
 * to randomize the order in which those cards are stored
 * 
 * @author Adam Sachs, ajs2255
 */
public class Shuffle {
	
	/**
	 * main method that runs the program
	 * @param args
	 */
	public static void main (String[] args){
		CardGroup deck = null;
		try {
			deck = CardGroup.parseCG(IO.stdin.readLine());
		} catch (IOException e) {
			IO.stderr.println("Cannot shuffle this input.");
		}
		
		//the shuffle method is void, but it randomizes the deck
		deck.shuffle();
		//and the shuffled deck is now printed in string form
		IO.stdout.println(deck.toString());
	}

}
