package rsa;

public class ModInverse {
	
	//finds the multiplicative modular inverse of a modulo n
	//based on 'extended Euclidean algorithm'
	public static int multModInverse(int a, int n){
		int t = 0;
		int r = n;
		int newt = 1;
		int newr = a;
		while (newr!=0){
			int quotient = (int) r/newr;
			int temp = t;
			t = newt;
			newt = temp - quotient * newt;
			temp = r;
			r = newr;
			newr = temp - quotient * newr;
		}

		if (t<0){
			t = t+n;
			
		}
		return t;
	}

}
