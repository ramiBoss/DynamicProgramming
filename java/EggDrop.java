import java.lang.*;


class EggDrop{

static int solveDrop(int floors,int eggs){
int[][] dp=new int[eggs+1][floors+1];
int i,j,k;
for(i=1;i<=floors;i++)
dp[1][i]=i;

for(i=2;i<=eggs;i++){
for(j=1;j<=floors;j++)
{
if(i>j)
dp[i][j]=dp[i-1][j];

else{
for(k=1;k<=j;k++){
dp[i][j]=1+Math.min(Math.max(dp[i-1][k-1],dp[i][j-k]),dp[i-1][j]);
System.out.print(dp[i][j]+" ");}
}
}

}
return dp[eggs][floors];
}

public static void main(String args[]){
int floors,eggs;
floors=6;
eggs=2;
System.out.print("Min Drops Required" +solveDrop(floors,eggs));
}
}