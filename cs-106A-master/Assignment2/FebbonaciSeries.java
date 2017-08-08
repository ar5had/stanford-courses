import acm.program.*;
public class FebbonaciSeries extends ConsoleProgram {
	
	public void run(){
		
		println("this program gives you febbonaci series upto your no.So enter you no!");
		int a=readInt("??");
		
		int t1=0;
		int t2=1;
		int sum;int c=0;
		while(t1<=a){
			
			sum=t1+t2;
			
			t1=t2;
			
			t2=sum;
			 
			if(c==5)
				println(t1);	
			
		}
		
	}
}
