import acm.program.*;

public class pattern extends ConsoleProgram{

	
	
	
	public void run(){
		
		int n=readInt("enter length of square:");
		
		int a=0;
		int b=n-1;
		int [][]arr=new int[n][n];
		int num=1;

		while(true){
			
			for(int i=a;i<=b;i++)
				arr[a][i]=num++;
			
			
			a++;
			
			if(num==n*n+1)
				break;
			
			
	
			for(int j=a;j<=b;j++)
				arr[j][b]=num++;
			
			if(num==n*n+1)
				break;
			
	
			for(int i=n-1-a;i>=n-1-b;i--)
				arr[b][i]=num++;
			
			b--;
			
			if(num==n*n+1)
				break;
			
			
	
			for(int j=n-1-a;j>=a;j--)
				arr[j][a-1]=num++;
		
			if(num==n*n+1)
				break;
			
	
	
		}//ends while
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j]<10)
					print("   "+arr[i][j]+" ");
				else if(arr[i][j]<100)
					print("  "+arr[i][j]+" ");
				else if(arr[i][j]<1000)
					print(" "+arr[i][j]+" ");
				else
					print(arr[i][j]+" ");
			}
			
			println();
			
		}
		
	
	}
		
}