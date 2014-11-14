package hearts;

import io.IO;

/**
 * NewDeck.java is a class that creates a new deck of cards
 * by calling the static NewDeck method of the CardGroup class.
 * It then converts this new deck into its string representation,
 * and prints it.
 * 
 * @author Adam Sachs, ajs2255
 */
public class NewDeck {

	/**
	 * main class that runs the program
	 */
	public static void main(String[] args) {
		CardGroup deck = CardGroup.newDeck();
		IO.stdout.println(deck.toString());
		
	}

}

