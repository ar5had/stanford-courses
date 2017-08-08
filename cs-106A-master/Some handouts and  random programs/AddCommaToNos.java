import acm.program.*;

public class AddCommaToNos extends ConsoleProgram{
	
	
	public void run() {   
		     
		
		String digits = readLine("Enter a integer numeric string: ");    
		
		     
		
		println(addCommasToNumericString(digits)); 
		
		
		}
	private String addCommasToNumericString(String digits){
		
		String newstring="";
		
		int dig=0;
		
		for(int i=digits.length()-1;i>=0;i--){
			
			newstring=digits.charAt(i)+newstring;
			
			dig++;
			
			if(dig%3==0  &&  i>0){
			
				newstring=","+newstring;
				
			}
			
			
			
		}
		
	
	return newstring;
	}

	

}
