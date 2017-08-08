import stanford.karel.*;
public class Borderr extends SuperKarel{

	public void run(){
		
		ascendUptoBorderPoint();
		
		while(noBeepersPresent()){
			
			makeBorder();
			
			moveAheadToNextBorderPoint();
			
		}
		
	}
	
		
	private void ascendUptoBorderPoint(){
		
		
		turnLeft();
		
		move();
		
		turnRight();
		
		move();
		
		
	}

	
	private void makeBorder(){
	
		while(frontIsClear()){
			if(noBeepersPresent())
			putBeeper();
			move();
		}
	}
	
	private void moveAheadToNextBorderPoint(){
		
		
		turnLeft();
		
		move();
		
		turnLeft();
		
		move();
		
		turnRight();
		
		
		
	}
}
