/*File name: bouncing ball
 * program of a bouncing ball
 * 
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class BouncingBall extends GraphicsProgram{

	private static final double BALL_RADIUS=20;
	 
	private static final double GRAVITY=3;
	
	private static final double HORIZONTAL_VELOCITY=5;
	
	private static double VERTICAL_VELOCITY=0;
	
	private static final double BOUNCE_COEFFICIENT=.9;
	
	
	public void run(){
		
		
		
		addBall();
		
		while(ball.getX()<getWidth()){
			
			moveBall();
			
			checkForCollision();
			
			pause(50);
		
		}
		
		
		
		
		
		
	}//ends run
	
	
	private void moveBall(){
		
		VERTICAL_VELOCITY+= GRAVITY;
		
		ball.move(HORIZONTAL_VELOCITY,VERTICAL_VELOCITY );
		
	}
		
		
	private void addBall(){
		
		ball=new GOval(2*BALL_RADIUS,2*BALL_RADIUS);
		
		ball.setFilled(true);
		
		ball.setFillColor(Color.RED);
		
		ball.setColor(Color.RED);
		
		add(ball,(-BALL_RADIUS),100);

		
	}
	
	private void checkForCollision(){
		
		if( ball.getY()+(2*BALL_RADIUS)> getHeight())
		{
		VERTICAL_VELOCITY=-VERTICAL_VELOCITY*BOUNCE_COEFFICIENT;	
		
		double diff=ball.getY()+(2*BALL_RADIUS)-getHeight();
		
		ball.move(0, -1*diff);
		 
		}
	}
	
	
	
	private GOval ball;
	
	
	
}
