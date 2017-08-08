/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry  implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		if(line!=null){
		
		StringTokenizer token= new StringTokenizer(line);
		
		int loop=1;
		int gap=0;
		while(token.hasMoreTokens()){
			
			String next=token.nextToken();
			
			if(loop==1){
				
				name=next;
				
				loop=-1;
			}
			else{
				int year=START_DECADE+gap;
				int value=Integer.parseInt(next);
				
				data.put(year, value);
				
				gap+=10;
			}
			
			
		}//ends while loop
		
		
		}
		
		
	}//ends constructor

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		
		return name;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		
		if(data.get(decade)!=null)
		return data.get(decade);
		else
			return 0;
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		
		String collectionOfValues=null;
		
		if(name!=null){//here we checked if line send to namesurferentry is not null,by checking name which is assigned value from null to a proper name in above constructor only if line given to it was nott null
		 collectionOfValues=name+" [";
		
		int i;
		
		for( i=1900;i<2000;i+=10){
			
			collectionOfValues+=data.get(i)+" ";
			
		}
		collectionOfValues+=data.get(i)+"]";
		}
		return collectionOfValues;
		
	}
	
	String name=null;
	private HashMap<Integer,Integer> data= new HashMap<Integer,Integer>();
}


