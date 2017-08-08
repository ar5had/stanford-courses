import acm.program.*;
public class GCD extends ConsoleProgram{

	public void run(){
		
		int x=readInt("Enter no");int y=readInt("Enter no");
		
		

		min=Math.min(x, y);
		max=Math.max(x, y);
		
	println("GCD="+findGcd(max,min));
		
		
		
		
	}
	
	private int findGcd(int x,int y){
		
		if(y==0)return x;
		
		if(x%y==0)
			
			return y;
		
		else
			
			return findGcd(y,x%y);
	}

private int min,max;
}



