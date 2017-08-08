/* 
 * File name:RollDice.java
 * This program rolls some user given numbers of 6-sided dice until we get maximum value.
 */

import acm.util.*;
import acm.program.*;

public class RollDice extends ConsoleProgram {
	
	/*NUM_SIDES is constant whose value is equal to no of side of dice*/
	
	public static final int NUM_SIDES=6;
	
	public void run(){
		
		/* takes no of dice to be rolled */
		
		int dice=readInt("enter no of dice !");
		
		/* count counts no of rolling of dice */
		
		int count=0;
		
		/* total takes sum of digits that get as result when dices aare rolled */
		
		int total;
		
		while(true){
			
			count++;
			
			total=rollDice(dice);
			
			if(total==NUM_SIDES*dice){
				break;
			}
			println("you rolled a sum of "+ total);
			
		}
		
		println("you rolled maximum sum of "+ total +"after "+count+" rolls.");
		
		
	}
	
	/* rollDice is a method that counts total of result of all dices rolled */
	
	private int rollDice(int dice){
		int total=0;
		
		for(int i=1;i<=dice;i++){
			total=total+rgen.nextInt(1,6);
			
		}
			
		return total;
	}
	private RandomGenerator rgen = new RandomGenerator();

}
