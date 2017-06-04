package programs;

import java.util.Scanner;


@SuppressWarnings("unused")
class Box{
	int length,width,height;
	
	Box(int a,int b,int c){
		length=a;
		width=b;
		height=c;		
	}
	
	Box(){
		
	}
	
	public Box Rotate(int height,int side1,int side2){
		Box d=new Box();
		d.height=height;
		
		if(side1>=side2)
		{
			d.length=side1;
			d.width=side2;
		}
		else{
			d.length=side2;
			d.width=side1;
		}
		return d;
		
	}
	//Sort in decresing order of base area.
	public static int[] sort(Box[] BoxRotated,int size){
		int[] arr = new int[size];
		int[] array= new int[size];
		
		for(int i=0;i<BoxRotated.length;i++){
			
			int current=BoxRotated[i].length*BoxRotated[i].width;
			//array[i]=i;
			int curptr=i;
			//if(i > 0)
			for(int j=0;j<i;j++){
				
				if(arr[j] < current){
					int temp=current;
					int temp2=curptr;
					current=arr[j];
					curptr=array[j];
					array[j]=temp2;
					arr[j]=temp;
				}
			}
			arr[i]=current;
			array[i]=curptr;
		}
		return array;
	}
}


public class BoxStacking {
	
	
	@SuppressWarnings("unused")
	public static void DoDp(int[] a1,int[] a2,Box[] box){
		int new_index=-1,new_max=0;
		int[] orig=new int[a2.length];
		
		for(int i=0;i<a1.length;i++){
			orig[i]=a2[i];
		}
		for(int i=1;i<a1.length;i++){
			int flag=0;
			new_index=-1;
			new_max=0;
			
			for(int j=0;j<i;j++){
				
				if(box[orig[j]].length > box[orig[i]].length && box[orig[j]].width > box[orig[i]].width)
				{
					flag=1;
					if(a1[i]+box[orig[j]].height > new_max){
					new_index=orig[j];
					new_max=a1[i]+box[orig[j]].height;
					
					
					/*if(i==5)
						System.out.print(new_max +" "+ new_index + " "+ j+ " " + orig[j] +"\n");*/
					}
					/*if(i==5)
						System.out.print(new_max +" "+ new_index + " "+ j+ " " + orig[j] +"\n");*/
					
				}
			}
			
			if(flag == 1){
			a2[i]=new_index;
			a1[i]=new_max;
			}
			
		}
		
		System.out.print("\nMax array\n");
		for(int i=0;i<a1.length;i++){
			System.out.print(a1[i] + "\t");
		}
		
		System.out.print("\nReturn array\n");
		for(int i=0;i<a2.length;i++){
			System.out.print(a2[i] + "\t");
		}
	}
	
	public static int DoStuff(Box[] box,int n){
		int total=n*3,index=0;
		int[] Array1=new int[total];
		int[] Array2=new int[total];
		
		Box[] BoxRotated=new Box[total];
		
		for(int i=0;i<n;i++){
			BoxRotated[index++]=box[i].Rotate(box[i].height,box[i].length,box[i].width);
			BoxRotated[index++]=box[i].Rotate(box[i].length,box[i].height,box[i].width);
			BoxRotated[index++]=box[i].Rotate(box[i].width,box[i].length,box[i].height);
		}
		
		System.out.println("L \t W \t H");
		for(int i=0;i<total;i++)
		{
			System.out.println(BoxRotated[i].length + "\t" + BoxRotated[i].width + "\t" + BoxRotated[i].height);
		}
		System.out.print("\n");
		Array2=Box.sort(BoxRotated,total);
		
		
		for(int i=0;i<Array2.length;i++){
			Array1[i]=BoxRotated[Array2[i]].height;
		}
		
		System.out.print("\nthe return array\n");
		for(int i = 0;i<Array1.length;i++){
			System.out.print(Array2[i] + "\t");
		}
		System.out.print("\nthe max array\n");
		for(int i = 0;i<Array1.length;i++){
			System.out.print(Array1[i] + "\t");
		}
		DoDp(Array1,Array2,BoxRotated);
		return 0;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box[] box =new Box[2];
		box[0]=new Box(1,2,4);
		box[1]=new Box(3,2,5);
		DoStuff(box,box.length);
		//int n,l,w,h;
		
		/*Scanner in=new Scanner(System.in);
		System.out.print("How many boxes");
		n=in.nextInt();
		box=new Box[n];
		
		for(int i=0;i<n;i++){
			System.out.print("Enter Values into box" + i);
			l=in.nextInt();
			w=in.nextInt();
			h=in.nextInt();
			box[i]=new Box(l,w,h);
		}*/
		
		
	}

}
