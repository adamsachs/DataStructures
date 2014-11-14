/*
 * Program to RSA encode/decode a message given the public/private
 * encryption keys in a file
 *  titled '[prefix].public' or [prefix].private'
 *  Note: filename should be inputted by user in commandline
 */

package rsa;

import java.io.IOException;

import io.IO;

public class Encode {
	
	public static void main(String[] args){
		
		//ensures user has put in a command line arg for
		//the name of the file with encryption keys to use
		if(args.length!=1){
			IO.stderr.println("type filename of key as command line arg");
			return;
		}
		
		String fileName = args[0];
			
		//if the given file is a public file, we have been given public
		//keys, and therefore we want to encode
		if (fileName.endsWith("public")){
			try{
				String[] keys = IO.readFile(args[0]).split(":");
				//'e' is given before the colon
				int pubKey = Integer.parseInt(keys[0]);
				
				//takes the \n character away from the end of what
				//was given after the colon
				keys[1] = keys[1].replaceAll("(\\r|\\n)", "");
				
				//'n' was given after the colon
				int n = Integer.parseInt(keys[1]);
				
				//reads the message on the line given through
				//the input--should just be a single integer
				String currLine = IO.stdin.readLine();
				
				//loops until a blank line is read (i.e. we've reached EOF)
				while (currLine!=null){
					IO.stdout.println(
							//pass the message (which is a singe integer),
							//'e', and 'n' over to the 'encode' method
							Encryption.encode
							(Integer.parseInt(currLine), pubKey, n));
					//reads the next line
					currLine = IO.stdin.readLine();
				}
			}
			catch (IOException err) {
				IO.stderr.println
				("IO exception with writing to file");
			}
			catch (NumberFormatException err){
				IO.stderr.println
				("Could not parse int");
			}
		}
		
		///if the given file is a private file, we have been given private
		//keys, and therefore we want to decode
		//this process is analagous to the above process--we just pass
		//the message and keys to the decode function rather than encode
		else if (fileName.endsWith("private")){
			try{
				String[] keys = IO.readFile(args[0]).split(":");
				int privKey = Integer.parseInt(keys[0]);
				keys[1] = keys[1].replaceAll("(\\r|\\n)", "");
				int n = Integer.parseInt(keys[1]);
				String currLine = IO.stdin.readLine();
				while (currLine!=null){
					IO.stdout.println(
							Encryption.decode
							(Integer.parseInt(currLine), privKey, n));
					currLine = IO.stdin.readLine();
				}
			}
			catch (IOException err) {
				IO.stderr.println
				("IO exception with writing to file");
			}
			catch (NumberFormatException err){
				IO.stderr.println
				("Could not parse int");
			}
		}
		
		//error handling for file not ending with public or private
		else{
			IO.stderr.println
			("file needs to end with '.public' or '.private' extension");
			return;
		}
		
	}
}