package hearts;

import java.io.IOException;

import io.IO;

/**
 * Show.java is a class that takes a string representation of 4 CardGroups
 * or 'hands,' and calls the show() method from the CardGroup class
 * for each of these hands, which prints the hand in an organized fashion
 * 
 * @author Adam Sachs, ajs2255
 */
public class Show {
	/**
	 * main class that runs the program
	 */
	public static void main (String[] args) {
		String showString = "";
		
		try {
			//splits inputted string into 4 string representations 
			//of hands, which are separated by "::," as prescribed 
			//in the 'deal()' method. the 4 string representations
			//of hands are stored in an array called 'cgHolder'
			String[] cgHolder = IO.stdin.readLine().split("::");
			
			
			//each hand's string representation is then parsed
			//and the resulting CG calls the show() method,
			//which will print out the hand in an organized manner
			for (int i=0; i<4; i++){
			showString +=CardGroup.parseCG(cgHolder[i]).show();
			}
		} 
		
		catch (IOException e) {
			IO.stderr.println("Cannot 'show' this input.");
		}
		IO.stdout.println(showString);
	}
}

