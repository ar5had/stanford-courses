/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		
		int startXPosition;
		
		int startYPosition;
		int bricksInBase=BRICKS_IN_BASE;
		for(int i=1;bricksInBase>=1;i++,bricksInBase--){
			
			startXPosition=(getWidth()-14*30)/2+(i*BRICK_WIDTH/2);
			startYPosition=(getHeight()-i*BRICK_HEIGHT);
			
			for(int j=1;j<=bricksInBase;j++,startXPosition+=BRICK_WIDTH){
				GRect rect=new GRect(startXPosition,startYPosition,BRICK_WIDTH,BRICK_HEIGHT);
				add(rect);
				
			}
		
		
		
		
		
		}
			
			
			
			
			
			
			
			
			
	}
}

