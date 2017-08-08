/* 
 * File Name:Square.java
 * ---------------------
 * this programs displays a square whose color is changed to a random color every second.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Square extends GraphicsProgram {

	public void run(){
		
		GRect Square=new GRect(getWidth()/2-200,getHeight()/2-200,400,400);
		
		Square.setFilled(true);
		
		while(true){
			
			Square.setFillColor(rgen.nextColor());
			add(Square);
			pause(1000);
			
		}
		
		
		
		
	}
	
	private RandomGenerator rgen = new RandomGenerator();
}
