package hearts;

import io.IO;

/**
 * CardGroup.java is a class that models a group of playing cards
 * 
 * @author Adam Sachs, ajs2255
 */
public class CardGroup {
	//array that will store the cards in a card group:
	private Card[] cardArray;
	
	private int cgSize;
	private String cgName;


	/**
	 * Constructor for CardGroup
	 * 
	 * 
	 * @param size
	 * @param name
	 */
	public CardGroup (int size, String name){
		//creates the array of cards--size determined by argument
		this.cardArray = new Card[size];
		cgSize = size;
		cgName = name;	
	}
	
	
	/**
	 * creates a new CardGroup of 52 cards, called "deck"
	 * 
	 * @return deck
	 */
	public static CardGroup newDeck(){
		CardGroup deck = new CardGroup(52, "deck");
		for (int i=0; i<4; i++){
			for (int j=1; j<14; j++){
				//the deck has 52 cards w/ correct properties
				deck.cardArray[(i*13)+(j-1)] = new Card(i, j);
			}
		}
		return deck;
	}
	
	
	/**
	 * shuffles the CardGroup that calls the method
	 */
	public void shuffle (){
		
		//this swaps 2 random cards in the cardGroup 1000 times
		for (int i=0; i<1000; i++){ 
			int randomCard1 = ((int) (Math.random()*this.cgSize));
			Card tempCard1 = this.cardArray[randomCard1];
			int randomCard2 = ((int) (Math.random()*this.cgSize));
			this.cardArray[randomCard1] =
				 this.cardArray[randomCard2];
			this.cardArray[randomCard2] = tempCard1;
		}
		this.cgName = "shuffled deck";
	}
	
	
	/**
	 * called by a 52 card CardGroup, and creates 4 CardGroups,
	 * named "East," "West," "North," "South," each with 13 cards. 
	 * 
	 * @return the string representation of these 4 cardGroups (i.e. hands)
	 */
	public String deal(){
		CardGroup east = new CardGroup(13, "East");
		CardGroup west = new CardGroup(13, "West");
		CardGroup north = new CardGroup(13, "North");
		CardGroup south = new CardGroup(13, "South");
		
		//fills the hands with cards from 'this'
		for (int i=0; i<52; i++){
			if (i<13){
				east.cardArray[i] = this.cardArray[i];
			}
			if (i>=13 && i<26){
				west.cardArray[i%13] = this.cardArray[i];
			}
			if (i>=26 && i<39){
				north.cardArray[i%13] = this.cardArray[i];
			}
			if (i>=39){
				south.cardArray[i%13] = this.cardArray[i];
			}
		}
		
		//returns the string representations of the hands
		//different hands are separated by "::"
		return east.toString() + "::" + west.toString() + "::" +
			north.toString() + "::" + south.toString() + "::";
	}
	
	
	/**
	 * called by a 'hand' or 13 card CardGroup
	 * @return null if the hand does not contain 2 of clubs;
	 * returns the name of the hand if it does contain 2 of clubs.
	 */
	public String leader(){
		String cgLeader = null;
		for (int i =0; i<13; i++){
			if (this.cardArray[i].getSuit()==0 
					&&this.cardArray[i].getCardNumber()==2){
				cgLeader = this.cgName;
			}
		}
		return cgLeader;
	}
	
	
	/**
	 *returns a nicely formatted string
	 *representing the hand that calls it
	 */
	public String show(){
		String holder = null;
		holder = cgName + "\n";
		holder += "Clubs: ";
		
		//the two 'for loops' are called so that the for each suit,
		//the cards will be displayed in ascending order.
		//the first loop cycles through each possible card number (1-14)
		//the second one cycles through each card in the hand
		for (int i=1; i<14; i++){
			for (int j = 0; j<13; j++){
				if (this.cardArray[j].getSuit()==0 &&
					this.cardArray[j].getCardNumber()==i){
					holder +=(this.cardArray[j].
						getDisplayCardNumber() + " ");
				}
			
			}
		}
		
		holder += "Hearts: ";
		for (int i=1; i<14; i++){
			for (int j = 0; j<13; j++){
				if (this.cardArray[j].getSuit()==1 &&
					this.cardArray[j].getCardNumber()==i){
					holder += (this.cardArray[j].
						getDisplayCardNumber() + " ");
				}
			
			}
		}
		holder += "Diamonds: ";
		for (int i=1; i<14; i++){
			for (int j = 0; j<13; j++){
				if (this.cardArray[j].getSuit()==2 &&
					this.cardArray[j].getCardNumber()==i){
					holder += (this.cardArray[j].
						getDisplayCardNumber() + " ");
				}
			
			}
		}
		holder += ("Spades: ");
		for (int i=1; i<14; i++){
			for (int j = 0; j<13; j++){
				if (this.cardArray[j].getSuit()==3 &&
					this.cardArray[j].getCardNumber()==i){
					holder += (this.cardArray[j].
						getDisplayCardNumber() + " ");
				}
			
			}
		}
		
		holder += "\n" + "\n";
		return holder; 
	}
	
	
	/**
	 * returns the string representation of the CardGroup that calls it
	 */
	public String toString(){
		//first component of the string gives size of the CG as an int
		//different components of string are divided by semi-colon 
		String cardGroupString = this.cgSize + ";";
		//second component is the name of the CG as a String
		cardGroupString += this.cgName + ";";
		//the rest of the string is the string representation of cards
		//different cards are separated by semi-colon
		for (int i=0;  i<this.cgSize; i++){
		cardGroupString += this.cardArray[i].toString() + ";";
		}
		return cardGroupString;
	}
	
	
	/**
	 * creates a CardGroup from the string representation of a CardGroup
	 * @param cgInfo --this is the string representation of a CardGroup
	 * @return the parsed CardGroup
	 */
	public static CardGroup parseCG (String cgInfo){
		CardGroup parsedCG = null;
		int newCGsize = 0;
		
		//finds the first semi-colon:
		int splitPoint = cgInfo.indexOf(";");
		
		//sets the first component of the string as size of the new CG
		try{
			newCGsize = Integer.parseInt(cgInfo.substring
				(0, splitPoint));
		}
		catch (NumberFormatException e){
			IO.stderr.println("Formatting error");
		}
		
		//creates an array of the separated components of the string
		String[] holder = cgInfo.split(";");
		
		//constructs the new CG; holder[1] is the second component
		//of the  string we're parsing, which contains the CG name
		//as prescribed in "toString()" method
		parsedCG = new CardGroup (newCGsize, holder[1]);
		
		//for loop begins parsing cards at the 3rd component
		// of the string that's being parsed b/c that's where
		//the first card's string representation is held
		for (int j=2; j<newCGsize+2; j++){
			
			//we want the first card parsed to be placed in the
			//0th element of our new CG's array,
			//so we put it in element j-2
			parsedCG.cardArray[j-2]=Card.parseCard(holder[j]);	
		}
		return parsedCG;
	}
}

