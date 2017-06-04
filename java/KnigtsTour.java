
public class KnigtsTour {


public static void printSol(int[][] sol,int n){
	for(int i = 0;i<n;i++){
		for(int j = 0;j<n;j++)
			System.out.print(sol[i][j]+"\t");
		System.out.print("\n");
	}
}

	
		public static boolean isSafe(int x,int y,int[][] sol,int n){
		
			if(x>=0 && x<n && y>=0 && y<n && (sol[x][y]==-1))
			return true;
			
		return false;
		
	}
	
	public static boolean KnightSol(int x,int y,int movei,int[][] sol,int[] xmove,int[] ymove,int n){
		int i,k,nx,ny,l;
		if(movei == n*n)
			return true;
		
		for(k=0;k<n;k++){
			for(l=0;l<n;l++)
				System.out.print(sol[k][l]+"\t");
			System.out.print("\n");
		}
		
		
		for(i=0;i<8;i++){
			
			nx=x+xmove[i];
			ny=y+ymove[i];
			System.out.println("x="+nx+" y="+ny);
			
			if(isSafe(nx,ny,sol,n)){
				sol[nx][ny]=movei;
				movei=movei+1;
				System.out.println("Sol"+nx+ny+"="+movei);
				if(KnightSol(nx,ny,movei,sol,xmove,ymove,n))
					return true;
				else{
				sol[nx][ny]=-1;
				movei=movei-1;
				}
				
			}
		}
		
		return false;
	}
	
	
	public static int solveKT(int n){
		int[][] sol=new int[n][n];
		int i,j;
		
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				sol[i][j]=-1;
		
		for(i=0;i<n;i++){
			for(j=0;j<n;j++)
				System.out.print(sol[i][j]+"\t");
			System.out.print("\n");
		}
		
		int[] Xmove={  2, 1, -1, -2, -2, -1,  1,  2 };
	    int[] Ymove = {  1, 2,  2,  1, -1, -2, -2, -1 };
	    
		sol[0][0]=0;
		
		if(KnightSol(0,0,1,sol,Xmove,Ymove,n)==true){
			printSol(sol,n);
			return 1;
		}
		else
			System.out.print("Solution not exists");
			
			return 0;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solveKT(7);
	}

}
