
public class LongestSubsequence {

	public static boolean check(int[] arr,int start,int k,int end){
		int i,j,sum1=0,sum2=0;
		for(i=start,j=k;i<k && j<end;i++,j++){
			sum1+=arr[i];
			sum2+=arr[j];
		}
		if(sum1 == sum2)
			return true;
		else
			return false;
	}
	
	public static void dis(int[] arr,int start,int end){
		int i;
		for(i=start;i<end;i++)
		System.out.print(arr[i]+"\t");
		System.out.print("\n");

	}
	
	public static int Solve(int[] arr){
	int i,n,k,len = 0,max_len=0;
	boolean ret;	
		for(i=0;i<arr.length;i++){
			
			n=arr.length;
			while(i < n){
				if((i+n)%2==0){
					k=(i+n)/2;
					ret=check(arr,i,k,n);
					if(ret == true){
						len=n-i;
						dis(arr,i,n);
						break;
					}
				}
				n--;
			}
			
			max_len=Math.max(max_len,len);
		}
		return max_len;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={0,5,2,1,4,4,0,1,2};
		System.out.print("Max Length= "+Solve(arr));

	}

}
