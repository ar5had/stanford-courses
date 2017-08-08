
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;
import acmx.export.java.io.FileReader;


public class wordCount extends ConsoleProgram {

   public void run() {
	   BufferedReader rd,cd;
	   
	   rd=null;
	   
	   rd=openFileForLines(); 
	

	    println("file: lear.txt");
	   println("lines= "+line);
	   println("words= "+word());
	   println("chars="+chars);
	   
   }
   
   
   private BufferedReader openFileForLines(){
	   
	   BufferedReader rd=null;
	   
	   try{
		   
	   
	    rd =new BufferedReader (new FileReader ("lear.txt"));
	    
		    while(true){
		    	
		    	String str=rd.readLine();
		    	
		    	if(str==null)break;
		    	
		    	
		    	
		    	strlist.add(str);
		    	line++;
		    	chars+=str.length();
		    	
		    }
	    
	    
	    rd.close();
	   }
	  
	   catch(IOException ex){
		   throw new ErrorException(ex);
		   
	   }
	   
	   return rd;
   }

   

   
   private int word(){
	   
	   int i=0;
	   
	   int words=0;
	   while(i<strlist.size()){
	   
		   String line=strlist.get(i);
	
		   
			   
		   StringTokenizer tokenizer = new StringTokenizer(line,"',? ");
		   
		   while(tokenizer.hasMoreTokens()){
			   
			   String token = tokenizer.nextToken();
			   words++;
		   
		   }
		   
		   
		   i++;
	  
	   }
   return words;
   }
   
   private int line=0,chars=0;

   
   private ArrayList<String> strlist= new ArrayList<String>();
}