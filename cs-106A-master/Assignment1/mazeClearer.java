import stanford.karel.*;
public class mazeClearer extends SuperKarel{
	
	public void run(){
	
		
		
		
		
		while(noBeepersPresent()){
			
				
			move();
			
			turnRight();
			
			while(frontIsBlocked()){
				
				turnLeft();
			}
		}
		
		
		
	}

}
