
public class NumericPad {

	public static int NumPad(int n){
	
		int[][] pad=new int[10][n+1];
		int i,j,k=1;
		int[] button=new int[10];
		
		button[0]=2;
		button[1]=3;
		button[2]=4;
		button[3]=3;
		button[4]=4;
		button[5]=5;
		button[6]=4;
		button[7]=3;
		button[8]=5;
		button[9]=3;
		
		for(i=0;i<10;i++)
			pad[i][0]=1;
		
		for(i=0;i<10;i++){
			pad[i][1]=k;
			k++;
		}
		
		for(i=0;i<(n+1);i++)
			pad[0][i]=i;
		
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<(n+1);j++)
			{
				System.out.print(pad[i][j]+"\t");
			}
			System.out.print("\n");
		}	
		System.out.print("\n");
		
		for(i=2;i<=n;i++)
		{
			k=1;
			for(j=1;j<10;j++)
			{
				pad[j][i]=pad[j-1][i]+button[k];
				k++;
			}
		}
		
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<(n+1);j++)
			{
				System.out.print(pad[i][j]+"\t");
			}
			System.out.print("\n");
		}			
		
		return pad[9][n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=4,ans;
ans=NumPad(n);
System.out.print(ans+"\t");
	}

}
