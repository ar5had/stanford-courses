/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 * 
 * 3 problems to solve:
 * 
 * 1-ball should start moving on mouse click
 * 2-power should be dropped
 * 3-ball velocity should get changed in both vx and vy when hit around eddges of paddle.
 * 
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet .*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400+4;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
/*
 * final is removed because we will change it as a power(it becomes a class var).
 */
	private static  int PADDLE_WIDTH = 400;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  ((WIDTH-BRICK_SEP) - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	
/*
* final is removed because we will change it as a power(it becomes a class var).
*/
	private static double BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		
		/* Method: setup() */
		/** Addss the bricks and paddle to screen */

		setup();
		
		/*
		 * if game is won or all chance are played then there is  no point in continuing the game.
		 */
		
		while(!gameWin || turnsPlayed!=NTURNS){
			
			
			gameOver=false;//for every turn gameOver is false so thAT game starts.
			
			/*
			 * if game is won then game will not continue further.
			 * if turns to play game is greater than zero then game will continue.
			 * 
			 */
			
			if(NTURNS-turnsPlayed>0 && !gameWin){
				
				/*Method:ball()*/
				/** adds ball after checking the conditions of gamewin and all turnns played */
			
				ball();
				waitForClick();
				
			}
			
			
			
			while(!gameOver && !gameWin){
				
				
				
				ballStartsMoving();
				
				checkForCollision();
				
			//	checkPowerRecieved();
				
				checkForGameWin();
				
				pause(4);//pause delay time.
				
				
		
			
			}
		
			if( turnsPlayed!=NTURNS && !gameWin){
				
				remove(ball);
				
				turnsPlayed++;
				
				remindTurnsLeft(NTURNS-turnsPlayed);
				
			}
			
			checksTurnLeft(NTURNS-turnsPlayed);
			if(NTURNS-turnsPlayed==0){
				break;
			}
		}

					
		
	}

	
	

	
/* Method: setup() */
/** Makes the setup of program. */
	
private void setup(){
	
	
	
	setBackground(Color.LIGHT_GRAY);
	
	
	
	addBricks();
	
	createPaddle();
	
	loadSound();
	
	gameScore();
	
}



	
/* Method: addBricks */
/** Add the bricks */
	
private void addBricks(){//working
	
	for(int i=0;i<NBRICK_ROWS;i++){
			
		for(int j=0;j<NBRICKS_PER_ROW;j++){
				
			 brick= new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				
			brick.setFilled(true);
				
			/*
			 * this switch statement gives color to bricks' row.
		     */
			switch(i){
				
					case 1: case 0:
						brick.setFillColor(Color.RED);
						brick.setColor(Color.red);
						break;
					case 3: case 2:
						brick.setFillColor(Color.ORANGE);
						brick.setColor(Color.ORANGE);
						break;
					case 5: case 4:
						brick.setFillColor(Color.YELLOW);
						brick.setColor(Color.YELLOW);
						break;
					case 7: case 6:
						brick.setFillColor(Color.GREEN);
						brick.setColor(Color.GREEN);
						break;
					case 9: case 8:
						brick.setFillColor(Color.CYAN);
						brick.setColor(Color.CYAN);
						break;
					
					
				} 
				add(brick ,j*( BRICK_SEP+BRICK_WIDTH ) + BRICK_SEP , BRICK_Y_OFFSET + i * (BRICK_HEIGHT+BRICK_SEP) );
			
			}
			
		}
		
	}//addBricks ends.


	
/* Method: createPaddle */
/** Create the paddle */
			
	
	private void createPaddle(){//working
		
		paddle=new GRect(PADDLE_WIDTH , PADDLE_HEIGHT);
		
		paddle.setFilled(true);
		
		paddle.setFillColor(Color.WHITE);
		
		add(paddle , ( getWidth()-PADDLE_WIDTH )/2 , getHeight() - PADDLE_Y_OFFSET );
		
        lastX=paddle.getX();
		
		addMouseListeners();
		
	}

/*
 * (non-Javadoc)
 * @see acm.program.Program#mouseMoved(java.awt.event.MouseEvent)
 *  * mouse moves the paddle.
 */
	
	
	public void mouseMoved(MouseEvent e){// working
		
		/*
		 * the first if statement is very important because if mouse is suddenly entered from right then paddle will move
		 * outside the boundry.
		 * check this complex algo and make it easy if possible. 
		 * 
		 */
		
		if( (e.getX()-paddle.getX()+PADDLE_WIDTH)+lastX>=WIDTH ){
			paddle.move(WIDTH-lastX-PADDLE_WIDTH,0);
			
			lastX=paddle.getX();
		}
			
		else if(e.getX()-paddle.getX()+lastX<=0){
			
			
			paddle.move(-lastX, 0);
			
			lastX=0;
		}
		else{
			
			paddle.move(e.getX()-lastX,0);
			
			lastX=e.getX();
		}
		
	}//ends mouseDragged
	
	
/* Method: loadSound() */
/** loads the audio clip that plays when ball hits brick */
	
	
private void loadSound(){
	
	bounceSound=MediaTools.loadAudioClip("bounce.au");
}
	
/* Method: gameScore() */
/** tracks score  */

private void gameScore(){
	
	score=0;
	
	displayScore();
	
}

private void displayScore(){
	
	userScore= new GLabel("SCORE:"+score);
	
	userScore.setFont("Courier-15-BOLD");
	
	userScore.setColor(Color.white);
	
	add(userScore,( getWidth()-userScore.getWidth())/2,50);
}

private void ball(){
		
	addBall();
		
	setBallSpeed();
		
	

}
	

 
/* Method : addBall() */
/** adds ball to the canvas */
 
private void addBall(){//working
		
	 ball = new GOval(2*BALL_RADIUS,2*BALL_RADIUS);
		
	 ball.setFilled(true);
		
	 ball.setFillColor(Color.BLUE);
	 
	 ball.setColor(Color.BLUE);
		
	 add(ball,getWidth()/2-BALL_RADIUS,getHeight()/2-BALL_RADIUS);
		
}//ends addBall




/* Method : setBallSpeed() */
/** sets initial speed of ball */
	
private void setBallSpeed(){//working
		
	vx=rgen.nextDouble(1.0,5.0);
		
	if(rgen.nextBoolean(.5)){
			
			vx=-vx;
	}
	vy=5;
	
	
}




/* Method: ballStartsMoving() */
/** Makes the ball move. */

private void ballStartsMoving(){//working

	
		
	ball.move(vx,vy);
	
//	powerPolygon.move(0, 2);
	
		
}
	


/* Method: checkForCollision() */
/** Checks whether any collision has occured 
 * ,if yes then ball either bounces or bricks are removed */	
	
private void checkForCollision(){
		
		
		
		//collision from right left wall.
	
		collisionFromLeftRightWall();
		
		//collision from up down wall.
		
		collisionFromUpDownWall();
		
		//collision from bricks or paddle
		
		collisionFromBricksOrPaddle();
		
		
	}


private void collisionFromLeftRightWall(){//working
	
	
	if(!(ball.getX()>=0 && ball.getX()<WIDTH-2*BALL_RADIUS)){//working
		
		vx=-vx;
	}
	
	
	
}
		

private void collisionFromUpDownWall(){
	
	if( ( ball.getY()<=0 ) ){// working
		
		vy=-vy;
		
	}
	
	if (ball.getY()>=getHeight()-2*BALL_RADIUS ){
		pause(100);
		gameOver=true;
		
	}
	
}
		
private void collisionFromBricksOrPaddle(){
	
	collider= getCollidingObject();
	
	if(collider==paddle){
		
		vy=-vy;
	
		 double ydiff = ball.getY() - (paddle.getY() - 2*BALL_RADIUS);    
		
			if(ydiff!=0){
				
				
				 
				
			if(ball.getX() - paddle.getX()<PADDLE_WIDTH &&  ball.getX() - paddle.getX()>0){
				vx=-vx;
				ball.move(vx, -1 * ydiff);}
			else
				ball.move(vx, -1 * ydiff);
			}
			
			
	}
	
	else if (collider==null || collider == userScore /*|| collider==powerPolygon */){
		
		// empty for the caase when collider=null because in that condition nothing should happen.
	}
	
	
	
	else {//as other option for collider object is only brick
		
		
		bounceSound.play();
		vy=-vy;
		vx+=(vx)/100;
		brickRemoved++;
		
		updateScore();//updates score by checking brick's color.
		
		/*
		if(powerPolygon.getY()+20>HEIGHT){
			dropPower();
			
		}*/
		remove(collider);//try with setVisible()
		
	}
	
}

//takes colliding object returns it for checking whether it is paddle or brick.

	
private GObject getCollidingObject(){
		
		cornerElement=null;
		
		int cornerChecked=0;
		
		while(cornerChecked!=4){
			/*
			 * checking corner4 and corner3 first because they have the most prob. to collide with paddle
			 * where we are getting lag
			 */
			checkCorner4();
			cornerChecked++;
			
			if(cornerElement!=null){
				
				return cornerElement;
				
			}
			
			checkCorner3();
			cornerChecked++;
			
			if(cornerElement!=null){
				
				return cornerElement;
				
			}

			checkCorner1();
			cornerChecked++;
			
			if(cornerElement!=null){
				
				return cornerElement;
				
			}
			
			checkCorner2();
			cornerChecked++;
			
			if(cornerElement!=null){
				
				return cornerElement;
				
			}
		
	   	
	    }
		
		return cornerElement;
	
}


private void checkCorner1(){
	
	cornerElement=getElementAt(ball.getX(),ball.getY());

}

private void checkCorner2(){
	
	cornerElement=getElementAt(ball.getX()+(2*BALL_RADIUS),ball.getY());
	

}


private void checkCorner3(){
	
	cornerElement=getElementAt(ball.getX()+(2*BALL_RADIUS),ball.getY()+(2*BALL_RADIUS));
	

}

private void checkCorner4(){
	
	cornerElement=getElementAt(ball.getX(),ball.getY()+(2*BALL_RADIUS));
	

}

/*

private void checkPowerRecieved(){

	if (powerRecieved()){
		
		switch (powerType){
		
			case 1:
				vx=.5*vx;
				break;
				
			case 2:
				
				PADDLE_WIDTH=500;
				
				break;
				
				
			case 3:
				
				//fireGun();
				
				break;
				
			case 4:
				
				BALL_RADIUS=.5*BALL_RADIUS;
				
				break;
		
		
		}//ends Switch
	}//ends if

	
}//ends checkPowerRecieve
private boolean powerRecieved(){
	
	if(paddle.getY()== powerPolygon.getY()-20 && (powerPolygon.getX()>=paddle.getX() || powerPolygon.getX()<=paddle.getX()+PADDLE_WIDTH)){
		
		remove(powerPolygon);
		powerType=rgen.nextInt(1,4);
		
		
	}
	return true;
}
*/

/* Method: checkForGameWin() */
/** Tells the user that game is won by him. */


private void checkForGameWin(){
	
	if(brickRemoved==100){
		
		gameWin=true;
		
		removeAll();
		
		GLabel lab =new GLabel("You WIN!!!");
		
		lab.setFont("monospace");
		
		
	
		add(lab,getWidth()/2-lab.getWidth()/2,getHeight()/2-lab.getAscent()/2);
		
		
	}
	
}


/* Method: remindTurnsLeft() */
/** remind user of the turns left to win game. */

private void remindTurnsLeft(int turns){
	
	GLabel lab=new GLabel("You have "+turns+" turns left.");
	
	lab.setFont("monospace");
	
	add(lab,getWidth()/2-lab.getWidth()/2,getHeight()/2-lab.getAscent()/2);
	
	pause(500);
	
	remove(lab);
	
}

private void updateScore(){
	
	Color brickColor=collider.getColor();// here Color is class Whose var is used to GEt colo constant.
	
	if(brickColor.equals(Color.RED)){
		
		score+=25;
		
		remove(userScore);
		
		displayScore();
		
		
	}
	
	else if(brickColor.equals(Color.ORANGE)){
		
		score+=20;
		
		remove(userScore);
		
		displayScore();
	}

	else if(brickColor.equals(Color.YELLOW)){
	
		score+=15;
		
		remove(userScore);
		
		displayScore();
	}

	else if(brickColor.equals(Color.GREEN)){
	
		score+=10;
		
		remove(userScore);
		
		displayScore();
	}

	else if(brickColor.equals(Color.CYAN)){
	
		score+=5;
		
		remove(userScore);
		
		displayScore();
	}
	
	

	
	
}//ends updateScore

/*
private void dropPower(){
	
	
	
	if(powerBrick.nextBoolean(.25)){
		
		drop();
		
	
	}//ends if
	
	
	
}//ends dropPower
*/


/* Method:drop() */
/**drop a gpolygon that is a power
 */
/*

public void drop(){
	powerPolygon.addVertex(-20,0);
	powerPolygon.addVertex(0,-20);
	powerPolygon.addVertex(20,0);
	powerPolygon.addVertex(0,20);
	powerPolygon.setFilled(true);
	powerPolygon.setFillColor(rgen.nextColor());
	add(powerPolygon,collider.getX(),collider.getY());
	
}
*/
/* Method:checksTurnLeft() */
/**checks for any turn left,if not then remove all off the scree and displays "you loose" msg.
 */


private void checksTurnLeft(int turnsLeft){
	
	if(turnsLeft==0){
		
		
		
		removeAll();
		
		GLabel lab =new GLabel("You LOOSE!!!");
		
		lab.setFont("monospace");
		
		
	
		add(lab,getWidth()/2-lab.getWidth()/2,getHeight()/2-lab.getAscent()/2);
		
		
	}
	
}


	

private RandomGenerator rgen =new RandomGenerator();	

//private RandomGenerator powerBrick =new RandomGenerator();//brick that drops power on collision.

//private GPolygon powerPolygon=new GPolygon();
	
private double vx;

private double vy;
	
private GOval ball;

private double lastX;

private GObject collider;

private GObject cornerElement;

private GRect paddle;

private GRect brick;

private int brickRemoved=0;

private boolean gameOver;

private boolean gameWin=false;

private AudioClip bounceSound;

private int score;

private GLabel userScore;

private int turnsPlayed =0;

private boolean collision;


//private int powerType=0;
}
