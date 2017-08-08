/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel{
	
	public void run(){
	
		while(frontIsClear()){
			
			findArchAndRepair();//method finds other arch
			
		}
		
		repairArch();
	
	}
	
	private void repairArch(){
		
		turnLeft();
		while(frontIsClear()){
			while(noBeepersPresent()){
			
			putBeeper();
			}
		move();
		}
		if(noBeepersPresent()){
			putBeeper();
		}
		returnBack();
		
		
		
	}
	
	private void returnBack(){
	
		turnAround();
		while(frontIsClear()){
		
			move();
		}
		turnLeft();
	}
	
	private void findArchAndRepair(){
	
		int i=1;
		while(frontIsClear()){
			if(i%4==1){
				repairArch();
			}
			i++;
			move();
		}
		
		
	
	
	}
	
}

