package programs;
import java.util.*;
@SuppressWarnings("unused")
public class WordWrapByDp {
	//static Vector<Integer> v=new Vector<Integer>();
	static int line=10;
	static String[] wordArray;
	
	static int getwordcount(String str){				
		wordArray = str.split("\\s+");
		int wordCount = wordArray.length;		
		//System.out.println(wordCount + " "+wordArray[0].length());
		return wordCount;
	}
	
	static int solution(int[][] dp,int count){
		int[] arr1 = new int[count];
		int[] arr2 = new int[count];
		
		int i = count-1,min,lines=0,j = count-1;
		
		arr1[count-1]=dp[i][j];
		arr2[count-1]=j+1;
		min=arr1[count-1];
		
		for(i = count-2;i>=0;i--){
			
			/*j=count-1;
			int k = count-1;*/
			int minimum = 9999,min_index =0;
			
			/*if(dp[i][j] != 9999){
				arr1[i]=dp[i][j];
				arr2[i]=j+1;
			}
			else{*/
				
				for(j=count-1;j>i;j--)
				{
					if(dp[i][j-1] == 9999)
						continue;
					
					if((dp[i][j-1]+arr1[j] < minimum))
					{
						minimum=dp[i][j-1]+arr1[j];
						min_index=j;
					}
				}
				/*while(dp[i][j] == 9999)
					j--;
				
				while(k>i && dp[i][j] != 9999){
					
					if((dp[i][j]+arr1[k] < minimum)){
						minimum=dp[i][j]+arr1[k];
						min_index=k;
						if(k==j+1)
							j--;
					}
					k--;
				}*/
				
				arr1[i]=minimum;
				arr2[i]=min_index;
			}			
			if(arr1[i]<min)
				min=arr1[i];
			
		for(i=0;i<count;i++)
			System.out.print(arr1[i]+"\t");
		System.out.print("\n");
		for(i=0;i<count;i++)
			System.out.print(arr2[i]+"\t");
		i=0;
		while(i<count)
		{
				i=arr2[i];
				lines++;
		}
		System.out.print("Min=" + min + "\nLines=" + lines);
		return 0;
		
	}
	
	static int solveDp(int count){
		int[][] dp=new int[count][count];
		int i,j,sum=0;
		System.out.println("Making the matrix");
		
		for(i=0;i<count;i++){
			
			for(j=0;j<count;j++){
				
				if(j>=i && sum <=line){
					sum=sum+wordArray[j].length();
					if(sum<=line)
					    dp[i][j]=(int) Math.pow((line-sum),2);
					else
					    dp[i][j]=9999;
					sum=sum+1;	
				}
				else{
				    dp[i][j]=9999;
				}
		     }
			sum=0;
			}
		System.out.println("Printing the matrix");
		
		for(i=0;i<count;i++){
			for(j=0;j<count;j++)
				System.out.print(dp[i][j]+"\t");
			System.out.print("\n");
		}			
		solution(dp,count);
		return 0;
		
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int word;
		int[] arr;
		String str="Ramiz khan likes to code";
		word=getwordcount(str);
		System.out.println("Word Count=" +word);
		solveDp(word);
	}

}
