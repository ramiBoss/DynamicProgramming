
public class Maximum_Product_Cutting {
	
	
	public static int CutIt(int n){
		//int n;
		int[][] dptable=new int[n][n+1];
		int i;
		for(i=1;i<=n;i++)
			dptable[1][i]=i;
		
		for(i=1;i<n;i++)
			dptable[i][1]=1;
		
		for(i=2;i<n;i++){
			for(int j = 2;j<=n;j++){
				
				if((j/i) == 1)
					dptable[i][j]=1;
				
				if(j<i)
					dptable[i][j]=dptable[i-1][j];
				else{
				int a = j/i;
				dptable[i][j]=Math.max(dptable[i-1][j],a*dptable[i-1][j-a]);
				}
				/*else{
					dptable[i][j]=dptable[i-1][j];
				}*/
			}
		}
		
		
		for(i=0;i<n;i++){
			for(int j = 0;j<=n;j++){
				System.out.print(dptable[i][j]+"\t");
			}
			System.out.print("\n");
		}
				
		return dptable[n-1][n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8,ans;
		ans=CutIt(n);
		System.out.print("Answer= "+ ans);

	}

}
