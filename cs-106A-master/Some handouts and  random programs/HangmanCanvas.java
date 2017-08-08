/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;


public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		
		sX=getWidth()/2-BEAM_LENGTH;	
		 
		sY=getHeight()/2-SCAFFOLD_HEIGHT/2-30;
		
		
		add(scaffold,sX,sY);
		
		add(beam,sX,sY);
		
		add(rope,sX+BEAM_LENGTH,sY);
		
		
		

		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
		if(hiddenWord!=null){
			
			remove(hiddenWord);
			
		}
		
		hiddenWord= new GLabel(word);
		
		hiddenWord.setFont("Helvetica-25");
		
		add(hiddenWord,sX,sY+SCAFFOLD_HEIGHT+50);
		
		guessLeft--;
		
		
		/*condition for complete hung when some corrrect answer was given but not won the game so at last irrespective
		 * of correct ansswers given , completly hung graphic should be displayed.
		 */
		
		if(guessLeft==0 && word.indexOf('-')!= -1 ){
			
			completeHung();
			
		}
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		
		wrongGuessCounter++;
		
		wrongGuessHolder+=letter;
		
		if(wrongGuess!=null){
			
			remove(wrongGuess);
			
		}
		
//		wrongGuess.setFont("Times New Roman-26");
		
		wrongGuess=new GLabel(wrongGuessHolder);
		
		
		wrongGuess.setFont("serif");
		
		hangTheMan();
		
		
		add(wrongGuess,sX,sY+SCAFFOLD_HEIGHT+70);
	}
	
	
	private void completeHung(){
		
		while(wrongGuessCounter<=8){
			
			hangTheMan();
			
			wrongGuessCounter++;
			
		}
		
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 72;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	
	public HangmanCanvas(){
		
		 scaffold= new GLine(0,0,0,SCAFFOLD_HEIGHT );
		
		 beam= new GLine(0,0,BEAM_LENGTH,0);
		
		 rope= new GLine(0,0,0,ROPE_LENGTH );
		
		 head=new GOval(2*HEAD_RADIUS,2*HEAD_RADIUS);
		
		 body= new GLine(0,0,0,BODY_LENGTH);
		
		 lupperarm= new GLine(0,0,-UPPER_ARM_LENGTH,0);
		
		 rupperarm= new GLine(0,0,UPPER_ARM_LENGTH,0);
		
		 llowerarm= new GLine(0,0,0,LOWER_ARM_LENGTH);
		
		 rlowerarm= new GLine(0,0,0,LOWER_ARM_LENGTH);
		
		 hip= new GLine(0,0,HIP_WIDTH,0 );
		
		 lleg= new GLine(0,0,0,LEG_LENGTH);
		
		 lfoot= new GLine(0,0,-FOOT_LENGTH,0 );
		
		 rleg= new GLine(0,0,0,LEG_LENGTH);
		
		 rfoot= new GLine(0,0,FOOT_LENGTH,0 );
	
	
}
	

	

	
private void hangTheMan(){
	
	switch(wrongGuessCounter){
	
	case 1:
		add(head ,sX+BEAM_LENGTH-HEAD_RADIUS,sY+ROPE_LENGTH );		
		break;
		
	case 2:
		add( body,sX+BEAM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS );
		break;
		
	case 3:
		add( lupperarm ,sX+BEAM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);	
		add(  llowerarm ,sX+BEAM_LENGTH-UPPER_ARM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);		
	
		break;
		
	case 4:
		add( rupperarm,sX+BEAM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		add( rlowerarm ,sX+BEAM_LENGTH+UPPER_ARM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD );
		
		break;
		
	case 5:
		add(  hip ,sX+BEAM_LENGTH-HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);		
		add( lleg,sX+BEAM_LENGTH-HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH  );
		break;
		
	case 6:
		
		add( rleg ,sX+BEAM_LENGTH+HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH );		
		break;
		
	case 7:
		add( lfoot ,sX+BEAM_LENGTH-HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH  );
		break;
		
	case 8:
		add( rfoot,sX+BEAM_LENGTH+HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH ) ;
		break;
		
	default:
		
		
		
	
	}

	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	private GLine scaffold;
	
	private GLine beam;
	
	private GLine rope;
	
	private GOval head;
	
	private GLine body;
	
	private GLine lupperarm;
	
	private GLine rupperarm;
	
	private GLine llowerarm;
	
	private GLine rlowerarm;
	
	private GLine hip;
	
	private GLine lleg;
	
	private GLine lfoot;
	
	private GLine rleg;
	
	private GLine rfoot;
	
	private int wrongGuessCounter=0;
	
	private String wrongGuessHolder="";
	
	private GLabel hiddenWord;
	
	private GLabel wrongGuess;
	
	private double sX;
	
	private double sY;
	
	private int guessLeft=8;
}
