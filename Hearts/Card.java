package hearts;

import io.IO;

/**
 * CardGroup.java is a class that models a playing cards
 * 
 * @author Adam Sachs, ajs2255
 */

public class Card {
	private int cardNumber;
	private int suit;
	private String displayCardNumber;
	
	
	public Card (int suitFormal, int cardNumberFormal){
		cardNumber = cardNumberFormal;
		suit = suitFormal;
		
		//assigns a card value in string form based on formal parameter
		//these will only be used when we want to "show" the hands
		//otherwise, all the card's info is stored through ints
		//i.e. "cardNumber" and "suit". 
		if (cardNumberFormal==1){
			displayCardNumber = "A";
		}
		if (cardNumberFormal>1 && cardNumberFormal<=10){
			displayCardNumber = Integer.toString(cardNumberFormal);
		}
		if (cardNumberFormal==11){
			displayCardNumber = "J";
		}
		if (cardNumberFormal==12){
			displayCardNumber = "Q";
		}
		if (cardNumberFormal==13){
			displayCardNumber = "K";
		}
		
		
	
	}
	
	
	/**
	 * the string representation of cards has the integer representing
	 * their suit and the integer representing their card number
	 * separated by a colon
	 */
	public String toString(){
		String cardString = suit + ":" + cardNumber;
		return cardString;
	}
	
	
	/**
	 * corresponding to the way that card's are turned into strings,
	 * cards are parsed from strings by splitting the the string into
	 * two substrings, one of which contains the suit int and the other
	 * containing the cardNumber int.
	 * @param cardInfo
	 * @return
	 */
	public static Card parseCard(String cardInfo){
		
		int splitPoint = cardInfo.indexOf(":");
		
		try{
			//this creates a card whose
			// parameters are the parsed integers
			//that were in the string representation of the card

			return new Card (Integer.parseInt
				(cardInfo.substring(0, splitPoint)),
					Integer.parseInt(cardInfo.substring
						(splitPoint+1)));
		}
		catch (NumberFormatException e){
			IO.stderr.print("Could not parse card.");
		}
		return null;
		
		
	}
	
	
	/**
	 * accessor method for the card's suit 
	 * @return
	 */
	public int getSuit(){
		return suit;
	}
	
	/**
	 * accessor method for the card's card number
	 * @return
	 */
	public int getCardNumber(){
		return cardNumber;
	}
	
	/**
	 * accessor method for the card's displayCardNumber
	 * @return
	 */
	public String getDisplayCardNumber(){
		return displayCardNumber;
	}
	
}
