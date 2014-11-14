package names;

import io.IO;

public class Person implements Comparable{
	private String firstName;
	private String lastName;
	private int id;
	
	public Person(String fn, String ln, int pid){
		firstName = fn;
		lastName = ln;
		id = pid;
	}
	
	//creates a person by parsing a string of person's name and pid
	//separated by spaces
	public Person (String fullName){
		//splits the string by spaces
		String[] currPerson = fullName.split(" ");
		firstName = currPerson[0];
		lastName = currPerson[1];
		try{
			id = Integer.parseInt(currPerson[2]);
		}
		catch (NumberFormatException e){
			IO.stderr.println("error parsing int");
		}
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public int getID(){
		return this.id;
	}

	public int compareTo(Object that) {
		Person otherPerson = (Person) that;
		
		int lastnamecomp = this.getLastName().
				compareTo((otherPerson.getLastName()));
		
		int firstnamecomp = this.getFirstName().
				compareTo((otherPerson.getFirstName()));
		
		int pidcomp = this.getID()-otherPerson.getID();
		
		//comparing lastnames first
		if (lastnamecomp !=0){
			return lastnamecomp;
		}
		
		//if identical lastnames, compare firstnames
		else if (firstnamecomp !=0){
			return firstnamecomp;
		}
		
		//if identical names in total, compare pids
		else return pidcomp;
	
	}
	
	//prints names and pid separated by spaces
	public String toString(){
		String personString = this.getFirstName()+ " "+ 
					          this.getLastName() + " "+ this.getID();
        return personString;	
	}
	
	
}
