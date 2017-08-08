import acm.program.*;
public class test extends ConsoleProgram{
	
	
	public void run(){
		
		ExpandableArray a=new ExpandableArray();
		
		a.set(5, "Bob");
		
		String b=(String)a.get(5);
		
		println(b);
		
		a.set(7, "ram");
		
		 b=(String)a.get(5)+(String)a.get(7)+(String)a.get(3);
		 
		 println(b);
		 
		 
	}

}
