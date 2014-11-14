package rsa;

public class Encryption {
	
	//encodes an integer 'message' using the 'key' and 'n'
	//as 'e' and 'N' respectively
	public static int encode(int message, int key, int n){
		return ModExp.calcModExp(message, key, n);
	}
	
	//decodes an integer 'encryptedMessage'
	//(which has already been encrypted) with 'key' and 'n'
	//as 'd' and 'N' respectively
	public static int decode (int encryptedMessage, int key, int n){
		return ModExp.calcModExp(encryptedMessage, key, n);
	}

}
