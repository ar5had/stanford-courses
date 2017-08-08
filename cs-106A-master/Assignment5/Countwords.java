import java.util.*;
import acm.program.*;
public class Countwords extends ConsoleProgram{

	public void run(){
	
		while(true){
			
			String str=readLine("?");
			
			if(str.equals(""))break;
			
			if(nn.get(str)==null)
				nn.put(str,new Integer(1));
			else
				nn.put(str,new Integer(1)+nn.get(str));
				
			
			
		}
		printnn();
	}
	
	
	
	private  void printnn(){
		
		for(String name:nn.keySet())
			println("Entry ["+name+"] has count "+nn.get(name));
		
	}
	
	
	
	private HashMap<String,Integer> nn=new HashMap<String,Integer>();
	
	
}
