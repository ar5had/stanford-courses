import acm.program.*;
public class Slrgest extends ConsoleProgram{

	public void run(){
		
		int no, l;int sl;int noGiven=0;
		
		
		
		println(" enter 0 to stop");
		no=readInt("?");
		sl=0;
		l=no;
		noGiven++;

		while(no!=0){
			
			
			if(no>=sl && no<=l)
				
				sl=no;
			
			else if(no>l){
			
				
				l=no;
				
			}
			
			
			
			no=readInt("?");
			
			noGiven++;
			
			
		}
		
		
		if(noGiven==1){
			
			println("Atleast enter a no other than 0");
			
		}
		
		else if(noGiven==2){
			
			println("Atleast enter 2 no to find second largest");
			
		}
		
		else{
			
			println("largest= "+l);
			println("2largest= "+sl);
			
		}
	}
	
	
}
