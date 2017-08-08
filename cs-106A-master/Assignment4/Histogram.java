import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;
public class Histogram extends ConsoleProgram{

	public void run(){
	
		BufferedReader rd=null;
		
		initArray();
		
		try{
			
			rd=new BufferedReader(new FileReader("MidtermScore.txt"));
			
			while(true){
				
				String str=rd.readLine();
				if (str==null)break;
				int no=Integer.parseInt(str);
				
				
				if(no<0|| no>100){
				
					throw new ErrorException("that score is out of range");
				}
				else{
					
					arr2[no/10]+="*";
				}
			
				
			}
			rd.close();
		}
		
		catch( IOException ex){
			
			println("Something Went Wrong Inbetween reading file!!");
			
			throw new ErrorException(ex);
			
		}
		
		printHist();
		
		
	}
	
	
	
	
	private void initArray(){
		
		for(int i=0;i<11;i++){
			
			arr2[i]="";
			
			
			
		}
		
	}
	
	
	private void printHist(){
		
		for(int k=0; k<11;k++){
			
			
		
			switch(k){
			
					case 0:
						println("00-09:"+arr2[k]);
						break;
					case 10:
						println("  100:"+arr2[k]);
						break;
					default:
						println(k*10+"-"+(k*10+9)+":"+arr2[k]);
			}
				
		}

	}
	
	private String[] arr2= new String[11];
	
}
