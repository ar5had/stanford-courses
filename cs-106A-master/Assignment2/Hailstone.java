/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int counter=0;
		int a=readInt("enter your + integer no ? ");
		
		while(a!=1){
				if (a%2!=0){
					
					a=3*a+1;
					println(a +" is odd so i make it 3n+1 = "+a);
					counter++;
				}
				else{
				
					a=a/2;
					println("a is even so i make it n/2 = "+a);
					counter++;
				}
		}
		println("total no of steps taken = "+counter);
	}
}

