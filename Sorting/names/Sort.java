package names;
import java.io.IOException;

import io.IO;

public class Sort {

	/**
	 * @param options; args[0] = '-q' for quicksort; '-h' for heapsort
	 * args[1] = '-stats' if stats are to be returned
	 */
	public static void main(String[] args) {
		Person people[] = new Person[1000];
		for (int i = 0; i<1000; i++){
				try {
					people[i] = new Person(IO.stdin.readLine());
					}
				catch (IOException e) {
					IO.stderr.println("error reading in people.");
				}
		}
		
		//converts the person array into an array that can be sorted
		Array peopleArray = new Array(people);
			if (args.length!=1 && args.length!=2){
				IO.prompt("Please type '-h' or '-q' for quicksort or heapsort, respectively\n");
			}
			
			//heapsorts the people
			if (args[0].equals("-h")){
				peopleArray.heapsort();
				if (args.length==2){
					if (args[1].equals("-stats")){
						IO.stdout.println("Element Comps: " + peopleArray.getComps() +
								", Swaps: "+ peopleArray.getSwaps());
						}
					
					else{
						IO.prompt("pleaes write '-stats' as your second argument to display stats\n");
					}
				}
				else{
					for (int i = 0; i<peopleArray.length(); i++){
						IO.stdout.println(peopleArray.values[i]);
					}
				}
			}
			
			//quicksorts the people
			else if (args[0].equals("-q")){
				peopleArray.quicksort();
				if (args.length==2){
					if (args[1].equals("-stats")){
						IO.stdout.println("Element Comps: " + peopleArray.getComps() +
								", Swaps: "+ peopleArray.getSwaps());
						}
					
					else{
						IO.prompt("pleaes write '-stats' as your second argument to display stats\n");
					}
				}
				else{
					for (int i = 0; i<peopleArray.length(); i++){
						IO.stdout.println(peopleArray.values[i]);
					}
				}
			}
			
			else{
				IO.prompt("Please type '-h' or '-q' for quicksort or heapsort, respectively\n");
			}
	}

}
