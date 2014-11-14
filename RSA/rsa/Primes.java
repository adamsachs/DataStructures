package rsa;

public class Primes {
	
	//generates all prime numbers below the given value 'top'
	//using Eratosthenes sieve algorithm
	public static int[] genPrimes(int top){
		//'marked' array keeps track of which integers between
		//2 and the 'top' value are marked
		boolean[] marked = new boolean[top+1];
		
		//counts amount of numbers marked
		int count = 0;
		
		//initializes the list as all unmarked
		for (int i = 0; i<top+1; i++){
			marked[i] = false;
		}
		
		//goes until i reaches sqrt(size of the list),
		//marking the multiples of each unmarked number
		//that are below 'top'
		for (int i =2; i*i<top; i++){
			if (!(marked[i])){
				for (int j =2; i*j<=top; j++){
					if (!(marked[i*j])){
						marked [i*j] = true;
						count ++;
					}
				}
			}
		}
		
		//the unmarked numbers are prime and are what we want to return
		//they will be returned in an array, whose size top-count-1
		int[] primes = new int[top-count-1];
		for (int i = 2, j=0; i<top+1; i++){
			if (!(marked[i])){
				primes [j] = i;
				j++;
			}
		}
		return primes;
	}
}
