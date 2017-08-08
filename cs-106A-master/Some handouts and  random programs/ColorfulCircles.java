/* File name:ColorfulCircles.java
 *  * This program displays random circles of random colors ,random size at random position
*/

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
public class ColorfulCircles extends GraphicsProgram {
	
	
	public void run() {
		
		
		
		for(int i=0;i<10;i++){
			double rad=size.nextDouble(5.0,50.0);
			
			Color circleColor=color.nextColor();
			
			GOval circle= new GOval(2*rad,2*rad);
			
			circle.setFilled(true);
			
			circle.setFillColor(circleColor);
			
			circle.setColor(circleColor);
			
			double Xcoordinate=Xposition.nextDouble( 0.0, ( getWidth()-2*rad ) );
			
			double Ycoordinate=Yposition.nextDouble(0.0, ( getHeight()-2*rad ));
			
			add(circle,Xcoordinate,Ycoordinate);
			
		}
		
		
	}

	
private RandomGenerator color=new RandomGenerator();
private RandomGenerator size=new RandomGenerator();
private RandomGenerator Xposition=new RandomGenerator();
private RandomGenerator Yposition=new RandomGenerator();
}