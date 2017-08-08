import java.util.*;
import acm.util.*;

public class ExpandableArray {

	public ExpandableArray(){
		
		
		
	}
	public void set(int index,Object obj){
		
		if(!(index<0)&&index>prevIndex){
		
				arr1=new Object[index+1];
				arr1[index]=obj;
				
				for(int i=0;i<arr2.length;i++){
					arr1[i]=arr2[i];
					
					
				}
			
				arr2=arr1;
				prevIndex=index;
			}
		
		else{
			
			throw new ErrorException("index is not in legal. ");
		}
	}
	
	public Object get(int index){
		if(index<0)return null;
		
		Object obj= arr1[index];
		
		return obj;
	}
	
	
	private Object[] arr1,arr2=new Object[1];
	
	private int prevIndex;
	
}
