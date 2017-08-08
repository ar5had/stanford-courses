/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel{
int avenue=1;	char width;int steps=1;
public void run(){
	
	getWidth();
	checkForEvenOrOdd();
	putBeeperOnMidpoint();
	
}

private void getWidth(){
	while(frontIsClear()){
		move();
		avenue++;
	}
	turnAround();
	while(frontIsClear()){
		move();
	}
	turnAround();
	

}

private void checkForEvenOrOdd(){
	if(avenue%2==0){
		width='e';
	}
	else if (avenue%2==1 && avenue!=1 ){
		width='o';
	}
}

private void putBeeperOnMidpoint(){
	if(width=='o'){
	while(steps!=avenue/2)
	{
		move();
		steps++;
		
		
	}
	move();
	putBeeper();
	
	}
	else if (width=='e'){
		while(steps!=avenue/2)
		{
			move();
			steps++;
		}
		putBeeper();
		move();
		putBeeper();
	}
}


}