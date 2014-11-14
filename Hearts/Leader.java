package hearts;

import java.io.IOException;

import io.IO;

/**
 * Leader.java is a class that takes in 4 'hands' (i.e. 13 card CardGroups)
 * and has each of them call the leader() method from the CardGroup class,
 * which will return null if the hand doesn't contain the two of clubs,
 * and will return the hand's name if it does contain the two of clubs.
 * 
 * @author Adam Sachs, ajs2255
 */
public class Leader {
	
	/**
	 * main method that runs the program
	 * @param args
	 */
	public static void main(String[] args){
		try {
			
			//splits up the 4 different hands from the string input
			//stores them in an array called cgHolder
			String[] cgHolder = IO.stdin.readLine().split("::");
			
			//each hand will call the leader() method
			for (int i=0; i<4; i++){
				//if leader method returns a not-null string,
				//meaning that this hand has the two of clubs
				//then this hand's name will be printed
				if (CardGroup.parseCG(cgHolder[i]).leader()
					!=null){
					IO.stdout.println(CardGroup.
						parseCG(cgHolder[i]).leader());
				}
			}
		} catch (IOException e) {
			IO.stderr.println
				("Cannot find leader with this input.");
		}
	}
}
