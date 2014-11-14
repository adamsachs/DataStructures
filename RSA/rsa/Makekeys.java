/*
 * A program to generate public and private RSA keys
 * (with a p and q between 64 and 128)
 * Will write the public keys to a file titled [prefix].public
 * and the private keys to a file titled [prefix].private
 * Note: [prefix] is given be user in command line.
 */
package rsa;

import java.io.FileWriter;
import java.io.IOException;

import io.IO;

public class Makekeys {
	
	public static void main(String[] args) {
		
		//ensures user inputs a command line arg for the prefix
		//of the filename for the file to which the keys will be written
		if(args.length!=1){
			IO.stderr.println("Please type the filename as command line arg");
			return;
		}
		
		//calls method to generate all primes under 128
		int[] primes128 = Primes.genPrimes(128);
		
		//picks a random prime under 128 to be 'p'
		int p = primes128[(int)(Math.random()*primes128.length)];
		
		//if p is below 64, re-picks until p is above 64
		while (p<64){
			p = primes128[(int)(Math.random()*primes128.length)];
		}
		
		//same process for q
		int q = primes128[(int)(Math.random()*primes128.length)];
		while (q<64){
			q = primes128[(int)(Math.random()*primes128.length)];
		}
		
		//will be 'N' component of the keys
		int n = p*q;
		int phi = (p-1)*(q-1);
		
		//generates primes below 'phi'
		int[] primesphi = Primes.genPrimes(phi);
		
		//chooses the lowest prime number that does not evenly divide phi
		//as our 'e'value--guaranteed to be coprime with phi.
		int e = 1;
		for (int i=1; phi%e==0; i++){
			e = primesphi[i];
		}
		
		//calls method to find the multipilicative modular inverse
		//of e with modulus phi
		int d = ModInverse.multModInverse(e, phi);
		
		//writes the public key to a file with name 'prefix.public'
		//and private key to a file with name 'prefix.private'
		//keys are written in format "e:N" or "d:N"
		try{
			FileWriter fwPub = new FileWriter(args[0] + ".public");
			fwPub.write(e + ":" + n);
			fwPub.flush();
			FileWriter fwPriv = new FileWriter(args[0] + ".private");
			fwPriv.write(d + ":" + n);
			fwPriv.flush();
		}
		catch (IOException err) {
			IO.stderr.println
			("IO exception with writing to file");
		}
	}
}
	
	
	
	


