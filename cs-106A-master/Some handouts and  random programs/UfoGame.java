/* File name: UfoGame
 * 
 * This program makes a Ufo game
 */
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.awt.*;
public class UfoGame extends GraphicsProgram{
	
	/* SOME CONSTANTS USED IN PROGRAM  */
	
	private static final double UFO_WIDTH=30;
	
	private static final double UFO_HEIGHT=15;
	
	private static final double TANK_WIDTH=30;
	
	private static final double TANK_HEIGHT=15;
	
	private static  double ufoXspeed=5;//will change as ufo moves down
	
	private static final double BULLET_DIA=5;
	
	private static final double DELAY=10;
	
	
	
	/* RUN METHOD STARTS HERE   */
	
	
	public void run(){
		
		setup();
		
		while(!gameover && !gamewin){
			
			ufoMove();
			
			moveBullet();
			
			checkForCollision();
			
			checkGameOver();
			
			pause(DELAY);
		}
		
		
	}//ENDS RUN METHOD
	


	
	/* SETUP METHOD STARTS HERE-ADDS UFO ,TANK AND BULLET */
	
	
	
	private void setup(){
		
		ufo=new GRect(UFO_WIDTH,UFO_HEIGHT);
		
		ufoY=0;
		
		ufo.setFilled(true);
		
		add(ufo,getWidth(),ufoY);
		
		tank=new GRect(TANK_WIDTH,TANK_HEIGHT);
		
		tank.setFilled(true);
		
		add(tank, (getWidth()-TANK_WIDTH)/2 , getHeight()-TANK_HEIGHT);
		
		addBullet();
		
		
	}//ends setup()
	
	
	/* ADDBULLET METHOD STARTS HERE-ADDS BULLET TO SCREEN */
	
	

	private void addBullet(){
	
		bullet=new GOval(BULLET_DIA,BULLET_DIA);
		
		bullet.setFilled(true);
		
		bullet.setFillColor(Color.RED);
		
		bullet.setColor(Color.RED);
		
		add(bullet, getWidth()/2-BULLET_DIA/2 , getHeight()-TANK_HEIGHT-1*BULLET_DIA);
	
		
	}
	
	
	
	
/* UFO MOVE METHOD STARTS HERE-MOVES UFO TOWARDS LEFT AND AFTERENTIRE WIDTH OF SCRREEN COVERRED
 * THEN MOVES IT DOWN AND REPEAT ABOVE
 */
	
	
	private void ufoMove(){
		
		checksUfoIsLeft();
		
		if(ufoIsLeft){
		
		ufo.move(-ufoXspeed,0);
		
		}//ends if
		
	}//ends ufoMove
	
	
	
	

/* CHECCK UFO IS LEFT OR NOT ,IF NOT THEN TAKE IT LEFT AND DOWN BY ITS' HEIGHT */
	
	
	
	
	
	private void checksUfoIsLeft(){
		
		if(ufo.getX()<=-UFO_WIDTH){
			
			ufoIsLeft=false;
			
			ufo.move(0,UFO_HEIGHT);
			
			ufoY+=UFO_HEIGHT;
			
			ufoXspeed+=.1*ufoXspeed;
			
			ufo.setLocation(getWidth(),ufoY);
			
			ufoIsLeft=true;
		}//ends if
		
	}//ends check ufoIsLeft()
	
	
	
	
	/* BULLETMOVE METHOD STARTS HER-MOVES BULLET UPWARDS  */
	
	
	private void moveBullet(){
		
		if(bullet!=null && !bulletMotion){
				
			addMouseListeners();
		}
		
		else if(bullet!=null && bulletMotion){
			
			bullet.move(0,-5);
			
		}
		
		else{
			
			addBullet();
			
		}
				
	}
	
	public void mouseClicked(MouseEvent e){
		
		
		bulletMotion=true;
		
		
		
	}
	
	
	private void checkForCollision(){
		
		collisionWithUfo();
		
		moveOffScreen();
		
		
	}
	
	
	
	private void collisionWithUfo(){
		
		GObject collider;
		
		collider=getElementAt(bullet.getX(),bullet.getY());
		
		
		if(collider == ufo){
			
		bullet=null;
		
		ufo=null;
		
		gameWinMsg();
			
		}
		
	}
	
	private void moveOffScreen(){
		
		if(bullet.getY()<-BULLET_DIA){
			
		bullet=null;	
		
		bulletMotion=false;
		}
		
	}
	

	
	
	private void checkGameOver(){
		
		if( ufoY >= (getHeight()-UFO_HEIGHT) ){
			
			gameOverMsg();	
		}
		
	}// ends checckGameOver()
	
	
	private void gameOverMsg(){
		
		gameover=true;
		
		removeAll();
		
		GLabel lab=new GLabel("UFO Landed,You LOOSE bouy!");
		
		lab.setFont("New Times Roman-30-BOLD");
		
		add(lab,( getWidth()-lab.getWidth() )/2, ( getHeight() - lab.getAscent() )/2 );
	
	
		
		
	}
	
	private void gameWinMsg(){
		
		gamewin=true;
		
		removeAll();
		
		GLabel lab=new GLabel("UFO DESTROYED!,You WIN bouy!");
		
		lab.setFont("New Times Roman-30-BOLD");
		
		add(lab,( getWidth()-lab.getWidth() )/2, ( getHeight() - lab.getAscent() )/2 );
	
	
		
		
	}

private GRect ufo,tank; 	

private boolean ufoIsLeft=true;

private boolean gamewin=false,gameover=false,bulletMotion=false;

private double ufoY;

private GOval bullet;
}
