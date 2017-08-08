/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */


import acm.program.*;
import acm.util.*;



public class Hangman extends ConsoleProgram {

	
	public static final int APPLICATION_WIDTH = 1300;
	public static final int APPLICATION_HEIGHT =600;
	
	private HangmanCanvas canvas;
	
	public void init() {    
		canvas = new HangmanCanvas();  
		
		add(canvas); 
	}


	public void run(){
		
		
		canvas.reset();
			
		word=selectWord();
			
		println("Welcome to Hangman!");
			
		startGame();
			
		
		
	}
	
	
	private String selectWord(){
		
		HangmanLexicon wordFetcher= new HangmanLexicon();
	
		int wordNo=rgen.nextInt(0,wordFetcher.getWordCount()-1);
		
		return wordFetcher.getWord(wordNo);
		
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
			
			canvas.noteIncorrectGuess(ch);
			
		}
		
		else{
			noRightAnsGiven=false;
			
			println("Your guess is correct.");
			
			hiddenWordModifier();
			
			
		}
		
		
		
				
		canvas.displayWord(hiddenWord);
		
		
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
