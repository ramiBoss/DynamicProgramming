
public class MinCoins {
	
	
	public static int MinC(int[] coins,int sum){
		int i,j,n=coins.length;
		int[][] table=new int[n][sum+1];
		
		table[0][0]=0;
		/*for(i=1;i<(sum+1);i++)
			table[0][i]=-1;*/
		
		for(j=0;j<n;j++)
			table[j][0]=0;
		
		
		for(i=0;i<n;i++){
			for(j=1;j<(sum+1);j++)
			{
				
				if(i==0){
					if((j/coins[i]) >= 1)
						table[i][j]=(j/coins[i]);
					else
						table[i][j]=-1;
					
				}
				
				else{
				if(table[i-1][j%coins[i]] != -1)
					table[i][j]=j/coins[i]+table[i-1][j%coins[i]];
				else
					table[i][j]=table[i-1][j];
			  }
			}
		}
		
		for(i=0;i<n;i++){
			for(j=1;j<(sum+1);j++){
				System.out.print(table[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
				
		return table[n-1][sum];
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] coins={2,3,5,7};
int sum=8,min;
min=MinC(coins,sum);
System.out.print(min);		
	}

}
