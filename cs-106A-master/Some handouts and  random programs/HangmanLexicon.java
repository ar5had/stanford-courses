/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import acm.program.*;
import java.io.*;
public class HangmanLexicon extends ConsoleProgram{
	
	
	public HangmanLexicon(){
		
		BufferedReader rd= new BufferedReader( new FileReader ("HangmanLexicon.txt") );
		
		
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	}
	
	
	

	
	
	public void run(){
			
		word=selectWord();
			
		println("Welcome to Hangman!");
			
		startGame();
			
		
		
	}
	
	
	private String selectWord(){
	
		int wordNo=rgen.nextInt(0,9);
		
		return getWord(wordNo);
		
	}
	
	
	private void startGame(){
		
		setUp();
		
		while(turns < 8 && !gameWin){
	
			displayHiddenWord();
		
			askInput();
		
			checksInput();
			
			checkWin();
			
			checkLose();
			
			turns++;//it is important to put it down
			
		}
		
	}
	
	
	private void setUp(){
		
		turns=0;
		
		length=word.length();
		
		hiddenWordModifier();
		
	}
	
	private void hiddenWordModifier(){
		
			
			String modifiedWord="";
		
			for(int i=0;i<length;i++){
				
				
				
				if (noRightAnsGiven){// for the first time
					
				
					modifiedWord+="-";
			
				}
				
				else if(hiddenWord.charAt(i)!='-'){//for currectly guessed letters in earlier chance
					
					modifiedWord+=hiddenWord.charAt(i);
					
				}
				
				else if(!noRightAnsGiven && i==letterPos){//for new correct guess letter that may be multiple times present in word.
					
					modifiedWord+=ch;
					
					letterPos=word.indexOf(ch,i+1);
				}
				
				else if(!noRightAnsGiven && i!=letterPos){
					
					modifiedWord+="-";
					
				}
			
			}
			
			hiddenWord=modifiedWord;
			
			
	}//ends hiddenWordModifier
	
	
	
	
	private void displayHiddenWord(){
		
		println("The word now looks like this: "+hiddenWord);
		
	}
	
	private void askInput(){
		
		if(8-turns >=2){
		
			println("You have "+(8-turns)+" guesses left.");
			
		}
		
		else{
			
			println("You have only one guess left.");
			
		}
		
		ch=readChar();
		
		ch=Character.toUpperCase(ch);
		
		
	
	}
	
	private char readChar(){
		String str=readLine("Your guess: ");
		
		while(str.length()!=1){
			
			str=readLine("ILLEGAL,Enter a single character: ");
			
		}
		return str.charAt(0);
	}
	
	
	
	
	private void checksInput(){
		
		letterPos=word.indexOf(ch);
		
		if (letterPos==-1){
		
			println("There is no "+ch+" in the word");
			
			
		}
		
		else{
			noRightAnsGiven=false;
			
			println("Your guess is correct.");
			
			hiddenWordModifier();
			
			
		}
		
		
		
				
		
		
		
	}
	
	private void checkLose(){
		
		if(turns==7 && !(word.equals(hiddenWord))){
			
			println("You are completely HUNG!");
			
			println("The word was "+word);
			
			println("You lose.");
			
		}

		
	}
	
	
	private void checkWin(){
		
		
/*		right answer count is not taken to check gamewin because in case of */
		if(word.equals(hiddenWord)){
			
			
			println("You guessed the WORD: "+word);
			
			println("You win.");
			
			gameWin=true;
		}
		
		
	}
	
	
	private int letterPos;
	
	private char ch;
	
	private boolean noRightAnsGiven=true,gameWin=false;
	
	private String word,hiddenWord;
	
	private int length,turns;
	
	private RandomGenerator rgen = new RandomGenerator();
	
}
