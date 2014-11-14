package rsa;

public class ModExp {
	
	//an algorithm, called 'right to left binary method'
	//to find the modular exponentiation given a base 'b',
	//an exponent 'e', and a modulus 'm'
	public static int calcModExp(int b, int e, int m){
		int result = 1;
		while (e>0){
			if ((e%2)==1){
				result = (result * b) % m;
			}
			e = e>>1;
			b = (b*b) % m;
		}
		return result;
	}
}
