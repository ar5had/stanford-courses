/*
 * file name:PieValueSearch
 * ------------------------
 * this program finds value of pie on the principle of monte-carlo approximation.
 * 
 */

import acm.util.*;
import acm.program.*;
public class PieValueSearch extends DialogProgram{
	
	public void run(){
		int inside=0;
		/*
		 * loops goes upto the no of times for which darts are thrown.
		 * x counts abcissa value and y counts ordinate value.
		 *  underroot of their square's sum  must be less than 1(radius of circle)to lie in circle.
		 *  as rad=1 so there is no need of underoot as mentioned abovve.
		 * this way we find inside darts. 
		 */
		
		for(int i=0;i<DARTS_THROWN;i++){
				
			double x=rgen.nextDouble(-1.0,1.0);
			double y=rgen.nextDouble(-1.0,1.0);
			if( ((x*x )+ (y*y))<1){
			
				inside++;
			}
		
			
		}
		/* pie tells apprx value of pie*/
		double pie=(4.0*inside)/DARTS_THROWN;
		println("approx value of pie is = "+pie);
	}
	
	private static final int DARTS_THROWN=1000;
	
	private RandomGenerator rgen= new RandomGenerator();
}
