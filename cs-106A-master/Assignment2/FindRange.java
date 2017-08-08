/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		int max,min;
		
		println("This program tells largest and smallest of the integer nos you will enter.Enter 'o' to stop !");
		int a;
		a=readInt("?");
		max=min=a;
		if (a==0){
			println("you didnt entered any value");
		}
		while(a!=0){
			
			if(a>=max){
			
				max=a;
			}
			
			else if (a<=min){
				
				min=a;
			}
			a=readInt("?");
		}
		if(max!=0&&min!=0){
		println("largest value = "+max);
		println("smallest value = "+min);
		}
	}
}

