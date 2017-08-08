import acm.program.*;
public class remove extends ConsoleProgram{

	public void run(){
		
		String str=readLine("enter your string in a line\n ");
		String ch= readLine("enter your character that you want to omit\n");
				
		println( removedChString(str,ch));
		
	
	}
	
	
	private String removedChString(String str,String ch){
		
	//	String newstring="";
		
		
		while (true) { 
			int pos = str.indexOf(ch); 
			if (pos >= 0) {
				str = str.substring(0, pos) + str.substring(pos+ch.length()); 
				}
		else
			break;  
			}	
			
		
		
		return str;
	}
	
	
}
