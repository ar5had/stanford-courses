/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel{
	
	int row=1;
	int column=1;
	
	public void run(){
		
		while(leftIsClear()){
			
			fillRow();
			returnBack();
			ascendUp();
			
			
		}

		fillRow();
		returnBack();
	
	}
	
	private void fillRow(){
		
		while(frontIsClear()){
			
			if((row+column)%2==0){
				putBeeper();
			}
		move();
		column++;
		}
		if((row+column)%2==0){
			putBeeper();
		}
	
	}
	
	private void returnBack(){
		
		turnAround();
		while(frontIsClear()){
			move();
			column--;
		}
		
	
	
	}
	
	private void ascendUp(){
		
	 turnRight();
	 move();
	 row++;
	 turnRight();
	 
		
	}

}