
public class pattern {

	
	
	public static void main(String args[]){
		
		int a=0;
		int b=4;
		int [][]arr=new int[5][5];
		int num=1;

		while(true){
			
			for(int i=a;i<=b;i++)
				arr[a][i]=++num;
			
			a++;
			
			if(num==5*5)
				break;
			else
				System.out.println("feeding "+num+"value!");
			
	
			for(int j=a;j<=b;j++)
				arr[j][b]=++num;
			
			if(num==5*5)
				break;
			else
				System.out.println("feeding "+num+"value!");
			
	
			for(int i=4-a;i>=4-b;i--)
				arr[b][i]=++num;
			
			b--;
			
			if(num==5*5)
				break;
			else
				System.out.println("feeding "+num+"value!");
			
	
			for(int j=4-a;j>=a;j--)
				arr[j][a]=++num;
		
			if(num==5*5)
				break;
			else
				System.out.println("feeding "+num+"value!");
			
	
	
		}//ends while
	
	
	
	}
	
	
		
}
