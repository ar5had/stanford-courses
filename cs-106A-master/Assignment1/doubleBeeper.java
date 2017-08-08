import stanford.karel.*;
public class doubleBeeper extends SuperKarel {

	public void run(){
		
		moveToBeeper();
		
		doubleTheBeeper();
		
		moveBackToStart();
		
	}
	
	private void moveToBeeper(){
		
		while(noBeepersPresent()){
			move();
		}
		
	}
	
	private void doubleTheBeeper(){
		
		while(beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			putBeeper();
			moveBackToBeeper();
		}
		moveDoubledBeeperBack();
	}
	
	private void moveBackToBeeper(){
		
		turnAround();
		move();
		turnAround();
		
	}
	
	private void moveDoubledBeeperBack(){
		
		move();
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			putBeeper();
			turnAround();
			move();
		}
	}
	
	
	private void moveBackToStart(){
		
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}
		
		
		
}
