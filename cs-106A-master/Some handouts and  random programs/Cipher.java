/*
 * file name:cipher(advanced)
 * program encrypts words according to key
 */
import acm.program.*;


public class Cipher extends ConsoleProgram{
	
	
	public void run(){
		
		println("This program encryts text according to letter word cipher");
		
		String key=readKey();
		
		String plaintext=readLine("Enter you text in a line!\n");
		
		String encryptedText=encrypt(plaintext,key) ;
		
		String decryptedText=decrypt( encryptedText,key) ;
		
		println("Encrtypted text: " + encryptedText );
		
		println("Encrtypted text: " + decryptedText );
	}
		
	private String readKey(){
		
		String key=readLine("Enter your key");
		
		while(isNotLegalKey(key) ){
			
			println("Fool ! that key is not legal!");
			
			key=readLine("Enter your key again!");
			
		}
		
		return key;
	}
	
	
	private boolean isNotLegalKey(String key){
		
		if(key.length()!=26){
			
			return true;
		}
		
		for(int i=0;i<26;i++){
			
			char ch=key.charAt(i);
			
			if(!Character.isUpperCase(ch)){
				
				return true;	
				
			}
			
			for(int j=i+1;j<26;j++){
			
				if(key.charAt(i)==key.charAt(j)){
					
					
					return true;
				
				}
			}//ends loop(j)
			
		}//ends loop(i)
		return false;
		
		
		
	}//ends isNotlegalkey
	
	
	
	
	
	
	
	
	
	
	private String encrypt(String plaintext,String key){
		
		String ns="";
		
		for(int i=0;i<plaintext.length();i++){
			
			
			char ch=plaintext.charAt(i);
			if(!Character.isLetter(ch)){
				ns+=ch;
				
			}
			else{
				
			int n= Character.toUpperCase(ch)-'A';
			
			ns+=key.charAt(n);
			}
			
			
		}
		
		
		
		
		return ns;
	}
	

	
	private String decrypt(String ciphertext,String key){
		
		String ns="";
		
		for(int i=0;i<ciphertext.length();i++){
			
			char ch=ciphertext.charAt(i);
			
			int n= key.indexOf(ch);
			
			if(n!=-1){
				
			ns+=(char)('A'+n);
			}
			else{
				ns+=ch;
				
			}
			
			
		}
		
		
		
		
		return ns;
	}
	
	
	
	
		
		
}//ends class
	

