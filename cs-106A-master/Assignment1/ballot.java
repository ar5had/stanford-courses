import stanford.karel.*;
public class ballot extends SuperKarel{

	
	
	public void run(){
			move();
			while(frontIsClear()){
				
			checkBallot();	
			moveToNextBallot();
			}
	}
	private void checkBallot(){
		
			if(noBeepersPresent())
			{
				
				clearBallot() ;
				
			}
		
	}
	private void clearBallot(){
		
			turnLeft();
			clearFront();
			removeChads();
			turnAround();
			clearFront();
			removeChads();
			turnAround();
			goToBallotExit();
		
	}
	
	private void goToBallotExit(){
		while(rightIsBlocked()){
			move();
		}
		turnRight();
	}
			

	
	
	private void clearFront(){
			while(frontIsClear()){
				move();
				
				removeChads();
			
					
				}
	}
	
	private void removeChads(){
			if(beepersPresent()){
				
				while(beepersPresent()){
					
					pickBeeper();
		
				}	
				
			}
		
	}
	
	private void moveToNextBallot(){
		move();
		if (frontIsClear()){
			move();
		}
	}

}

