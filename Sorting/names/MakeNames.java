package names;
import io.IO;




public class MakeNames {

	/**
	 * @param firstNames file; lastNames file
	 */
	public static void main(String[] args) {
		//names are split by a space
		String[] firstNames = IO.readFile(args[0]).split(" ");
		String temp = firstNames[firstNames.length-1];
		firstNames[firstNames.length-1] = temp.substring(0, temp.length()-1);
		String[] lastNames = IO.readFile(args[1]).split(" ");
		temp = lastNames[lastNames.length-1];
		lastNames[lastNames.length-1] = temp.substring(0, temp.length()-1);

		//generates 1000 names by choosing random elements
		//from the 'names' arrays
		for (int i =0; i<1000; i++){
			int fnIndex = (int) (Math.random()* firstNames.length);
			String currFirstName = firstNames[fnIndex];
			int lnIndex = (int) (Math.random() * lastNames.length);
			String currLastName = lastNames[lnIndex];
			int id = 1000 + i;
			IO.stdout.println(currFirstName + " " + currLastName + " " + id);
		}
	}

}
