/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.*;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.util.ErrorException;
import acm.util.RandomGenerator;


public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		dialog.println("Welcome to Yahtzee!,play the ultimate fun game!");
		nPlayers = dialog.readInt("Enter number of players(Max:4 Players)");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		
		/*categplayed stores no of category played by all players*/
		
		int categPlayed=0;
		
		/*allocates scores to player that are obvious for category and dont change.
		 * Note- here in array size is taken a unit more than required*/
		
		scoreOfPlayersForCatg=new int[nPlayers+1][18];
		
		/*to keep track of category that players has already chosen*/
		selectedCatg=new boolean [nPlayers+1][18];
		
		initScoreOfPlayers();
		
		while(categPlayed!=13){
			
			
			/*This method plays chance for every layer until all category
			 * are played
			 */
			
			playChance();
			
			
			
			categPlayed++;
		}
		
		displayAndAddUpperAndBonusScore();
	
		displayAndAddLowerScore();
		
		displayFinalTotalScoreAndWinner();
	
		
	}
	

	private void initScoreOfPlayers(){
		
		for(int i=1;i<=nPlayers;i++){
			
			scoreOfPlayersForCatg[i][11]=25;
			scoreOfPlayersForCatg[i][12]=30;
			scoreOfPlayersForCatg[i][13]=40;
			scoreOfPlayersForCatg[i][14]=50;
			scoreOfPlayersForCatg[i][17]=0;
			scoreOfPlayersForCatg[i][UPPER_SCORE]=0;
			scoreOfPlayersForCatg[i][UPPER_BONUS]=0;
			scoreOfPlayersForCatg[i][LOWER_SCORE]=0;
			
			
		}
		
		
	}
	
	
	 
	 private void playChance(){
		 
		 	
		 
		 for(playerNo=1;playerNo<=nPlayers;playerNo++){
			 
			 display.printMessage(playerNames[playerNo-1]+"'s turn! Click on \" Roll Dice\" button to roll the dice.");
			 
			 /* rolls dice and modify it if user says*/
			 diceRoll(playerNo);
			 
			 
			
			 /*selects category and check if itis true and update score accordingly*/
			 categorySelected();
			 
			 
			 
		 }
		 
		 
	 }
	 
	 private void diceRoll(int i){
		 
		 display.waitForPlayerToClickRoll(i);
		 
		 rollTheDices();
		 
		 display.displayDice(diceRolledValue);
		 
		 /*this method gives 2 chancess to user to roll those 2 dices again whose value they
		  * dont like.
		  */
		 modifyDiceValues();
	 
		 
	 }
	 
	 private void rollTheDices(){
		 
		 diceRolledValue= new int[N_DICE];
		
		 //diceRolledValue= new int[]{2,2,2,3,3};
		 
		 for(int i=0;i<N_DICE;i++){
			 
			 
		 diceRolledValue[i]=rgen.nextInt(1,6);
			 
			 
		 }
		 
		 
	 }
	 

	
	 private void modifyDiceValues(){
		 
		 for(int i=1;i<3;i++){
			 display.printMessage("Select the dice you don't like,then click \"Roll Again\" to roll them again.");
		 
			 display.waitForPlayerToSelectDice();
			 
			 knowTheSelectedDice();
			 
			 rollAgainSelectedDices();
			 
			 display.displayDice(diceRolledValue);
		 }
		 
	 }
	
	 private void knowTheSelectedDice(){
		 
		 selectedDice= new int[N_DICE];
		 
		 for(int i=0;i<N_DICE;i++){
			 
			 if(display.isDieSelected(i)){
				 
				 selectedDice[i]=1;
			 }
			 else{
				 
				 selectedDice[i]=0;
			 }
		}
		 
		 
	 }
	 
	 private void rollAgainSelectedDices(){
		 
		 
		 
		 
		 for(int i=0;i<N_DICE;i++){
			 
			 
			 if(selectedDice[i]==1){
				 
				diceRolledValue[i]=rgen.nextInt(1,6);
			 }
			 
		 }
			  
	 }
	 
	 private void categorySelected(){
		 
		
		 int category= display.waitForPlayerToSelectCategory();
		 
		 while(selectedCatg[playerNo][category]){
			 
			IODialog dialog = getDialog();
			dialog.println("Select other category! This category is already selected.");
			category= display.waitForPlayerToSelectCategory();
		
		 }
			 
		 
		 
		 calcScoreForCatg(category);
		 
		 if(checkCategory(diceRolledValue, category)){
			 
			 
			 display.updateScorecard(category, playerNo,scoreOfPlayersForCatg[playerNo][category]);
			
			 scoreOfPlayersForCatg[playerNo][TOTAL]+=scoreOfPlayersForCatg[playerNo][category];
			 
			 display.updateScorecard(TOTAL, playerNo,scoreOfPlayersForCatg[playerNo][TOTAL]);
			 
			 selectedCatg[playerNo][category]=true;
			 
		 }
		 else{
			 
			 display.updateScorecard(category, playerNo, 0); 
			
			 display.updateScorecard(TOTAL, playerNo,scoreOfPlayersForCatg[playerNo][TOTAL]);
			 
			 selectedCatg[playerNo][category]=true;
		 }
		 
		 
	 }
	 
	 
	 private void calcScoreForCatg(int category){
		 
		 if(category!=11 && category!=12 && category!=13 && category!=14){
			 
			 
			 
			 if(category<=6){
				 
				 
				 scoreOfPlayersForCatg[playerNo][category]=sumOf(category);
				 
				 
			 }
			 
			 
			 else if(category==9||category==10||category==15){
				 
				 scoreOfPlayersForCatg[playerNo][category]=sumOfAllValuesOfDice();
				 
			 }
			 
			
			 
			 
		 }
			 
		 
		 
		 
	 }
	 
	 
		
		/*for category 1-6 ,scores are assigned*/
		private int sumOf(int category){
				
			int sum=0;
				
				for(int i=0;i<N_DICE;i++){
					
					if(diceRolledValue[i]==category){
						
						sum+=diceRolledValue[i];
					}
						
					
				}
				return sum;
		}
		
		
		/*for category  9-10and 16 */
		
		private int sumOfAllValuesOfDice(){
			
			int sum=0;
			
			
			for(int i=0;i<N_DICE;i++){
				
				
				sum+=diceRolledValue[i];
				
			}
			
			
			return (sum);
			
			
		}
		
		
		
		
	private void displayAndAddUpperAndBonusScore(){
		
		for(playerNo=1;playerNo<=nPlayers;playerNo++){
		
			for(int i=1;i<=6;i++){
				
				 scoreOfPlayersForCatg[playerNo][UPPER_SCORE]+=scoreOfPlayersForCatg[playerNo][i];
				 
				 
				
			}
		
		display.updateScorecard(UPPER_SCORE, playerNo,scoreOfPlayersForCatg[playerNo][UPPER_SCORE] ); 
			if(scoreOfPlayersForCatg[playerNo][UPPER_SCORE]>=63){
				
				scoreOfPlayersForCatg[playerNo][UPPER_BONUS]=35;
				
				display.updateScorecard(UPPER_BONUS, playerNo,scoreOfPlayersForCatg[playerNo][UPPER_BONUS] ); 
				
				
			
			}
			else{
				scoreOfPlayersForCatg[playerNo][UPPER_BONUS]=0;
				display.updateScorecard(UPPER_BONUS, playerNo,scoreOfPlayersForCatg[playerNo][UPPER_BONUS]); 
			}
		}
	}
		
	
	private void displayAndAddLowerScore(){
		
		for(playerNo=1;playerNo<=nPlayers;playerNo++){
		
			for(int i=9;i<=15;i++){
				
				 scoreOfPlayersForCatg[playerNo][LOWER_SCORE]+=scoreOfPlayersForCatg[playerNo][i];
				 
				 
				
			}
		
		display.updateScorecard(LOWER_SCORE, playerNo,scoreOfPlayersForCatg[playerNo][LOWER_SCORE] ); 
		
		}
	}	
		
	
	private void displayFinalTotalScoreAndWinner(){
		
		for(playerNo=1;playerNo<=nPlayers;playerNo++){
	 	
			scoreOfPlayersForCatg[playerNo][TOTAL]+=scoreOfPlayersForCatg[playerNo][UPPER_BONUS];
		
		display.updateScorecard(TOTAL, playerNo,scoreOfPlayersForCatg[playerNo][TOTAL] ); 
		
			if(scoreOfPlayersForCatg[playerNo][TOTAL]>winnerScore){
			 winnerScore=scoreOfPlayersForCatg[playerNo][TOTAL];
			 winner=playerNo;
			 
			}
		}//ends for loop
		
		display.printMessage("Congratulations,"+playerNames[winner-1]+",You are winner with a total score of "+winnerScore);
		
	}	

	
private boolean checkCategory(int[] dice,int category){

		
		switch(category){


		case ONES:case TWOS:case THREES:case FOURS:case FIVES:case SIXES:case CHANCE:
		

			return true;
	 		
		
		case THREE_OF_A_KIND:
		
			{HashMap<Integer,Integer> counter= new HashMap<Integer,Integer>();


			


			for(int i=0;i<N_DICE;i++){
	
				
				
				if(counter.get(dice[i])==null){
		                 
				counter.put(dice[i],1);
		               
				}
				
				else{
	
				counter.put(dice[i],1+counter.get(dice[i]));
	
				}
	
			}//ends for loop
	
	
			for(Integer i:counter.keySet()){
	
				if(counter.get(i)==3){
	
				return true;
	
				}
			
			}
			return false;
			}		

		case FOUR_OF_A_KIND:
			
		{	
			HashMap<Integer,Integer> counter= new HashMap<Integer,Integer>();
				
				for(int i=0;i<N_DICE;i++){
	
				
				
				if(counter.get(dice[i])==null){
		                 
				counter.put(dice[i],1);
		               
				}
				
				else{
	
				counter.put(dice[i],1+counter.get(dice[i]));
	
				}
	
			}//ends for loop
	
	
			for(Integer i:counter.keySet()){
	
				if(counter.get(i)==4){
	
				return true;
	
				}
			
			}
			return false;
		

		}
		
		case FULL_HOUSE:
			
		{	boolean tripleValue=false,doubleValue=false;
			
			HashMap<Integer,Integer> counter= new HashMap<Integer,Integer>();
				
				for(int i=0;i<N_DICE;i++){
	
				
				
				if(counter.get(dice[i])==null){
		                 
				counter.put(dice[i],1);
		               
				}
				
				else{
	
				counter.put(dice[i],1+counter.get(dice[i]));
	
				}
	
			}//ends for loop
	
	
			for(Integer i:counter.keySet()){
	
				if(counter.get(i)==3){
					
					tripleValue=true;
				
	
				}
				if(counter.get(i)==2){
					
					doubleValue=true;
				
	
				}
			
			}
			
			if(doubleValue && tripleValue)return true;
			else
			return false;
		

		}
			
		case SMALL_STRAIGHT://not working
{
			
			HashMap<Integer,Integer> counter= new HashMap<Integer,Integer>();
			
			for(int i=0;i<N_DICE;i++){
	
				
				
				if(counter.get(dice[i])==null){
		                 
				counter.put(dice[i],1);
		               
				}
			
			}//ends for loop
			
			if(counter.size()<4)return false;
			
			else if (counter.size()==5){
				
			return true;
			}
			
			else{
				counter.remove(3);
				counter.remove(4);
				IODialog dialog = getDialog();
				dialog.println(counter.size());
				
				
				if(counter.get(1)!=null && counter.get(2)!=null)
					return true;
				else if(counter.get(2)!=null && counter.get(5)!=null )
					return true;
				else if(counter.get(5)!=null && counter.get(6)!=null )
				return true;
				else
					return false;
			}
		}
			
			
		case LARGE_STRAIGHT:
		{
			
			HashMap<Integer,Integer> counter= new HashMap<Integer,Integer>();
			
			for(int i=0;i<N_DICE;i++){
	
				
				
				if(counter.get(dice[i])==null){
		                 
				counter.put(dice[i],dice[i]);
		               
				}
				
				else{// checking no repeated element condition
	
				return false;
				}
	
			}//ends for loop
			
			counter.remove(1);
			counter.remove(6);
			
			//at this point we are sure that there is no repeated element.
			if(counter.size()==4)
				return true;
			else
				return false;
			
		}
		
		
		case YAHTZEE:{

			HashMap<Integer,Integer> counter= new HashMap<Integer,Integer>();
			
			for(int i=0;i<N_DICE;i++){
	
				
				
				if(counter.get(dice[i])==null){
		                 
				counter.put(dice[i],dice[i]);
		               
				}
			}
			
			if(counter.size()==new Integer(1))return true;
			else
				return false;
				
			
		}
		
		
		default:
			
			throw new ErrorException("Error Comes With CheckingCategory");
		
		}//ends switch

	}
	
	

	
	
		
		
/* Private instance variables */
	private boolean[][] selectedCatg;	
	private int winner,winnerScore;
	private int[][] scoreOfPlayersForCatg;
	private int playerNo;
	private int[] selectedDice;
	private int[] diceRolledValue;
	//private int[] player;
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
