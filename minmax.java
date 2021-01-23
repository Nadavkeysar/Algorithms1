
public class minmax {
public static void minmax(int[]arr)
{ int min1=Integer.MAX_VALUE,  max1=Integer.MAX_VALUE;
	int first1=0, last1=0 ;
	int diff=Integer.MIN_VALUE;
	for(int i=0;i<arr.length-1;i++)
	{
		if(arr[i]<arr[i+1])
		{
			min1=arr[i];
			max1=arr[i+1];
			first1=i;
			last1=i+1;
			System.out.print(arr[i]+" "+arr[i+1]);
			diff=arr[i+1]-arr[i];
			break;
		}
		if(i==arr.length-2)
		{
			return;
		}
	}
	for(int i=last1+1;i<arr.length-1;i=i+2)
	{
		if(arr[i]<arr[i+1])
		{
			if(arr[i]<min1&&arr[i+1]>max1)
			{
				min1=arr[i];
				max1=arr[i+1];
				diff=arr[i+1]-arr[i];
				first1=i;
				last1=i+1;
			}
			else
			{
				if(arr[i+1]>max1)
				{
					max1=arr[i+1];
					diff=arr[i+1]-arr[first1];
					last1=i+1;
				}
				if(arr[i]<min1)
				{
					min1=arr[i];
					
				}
			}
		}
		else
		{
			if(arr[i+1]<min1)
			{
				min1=arr[i+1];
			}
			if(arr[i]>max1)
			{
				max1=arr[i];
				last1=i;
				
				diff=arr[i]-arr[first1];
			}
		}
		
		
		
	}

	if(arr.length%2!=0)
	{
		if(arr[arr.length-1]>max1)
		{
			diff=arr[arr.length-1]-arr[first1];
			last1=arr.length-1;
			max1=arr[arr.length-1];
		}
	}
	System.out.println("diffrence is : "+ diff);
	
	System.out.println("first is : "+ first1+ "   last is : " + last1);
	System.out.println("min is :" + arr[first1]+ "  max is : "+ arr[last1]);


}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int []a = {22,2,12,4,7,3,19,5};
    minmax(a);
	}

}
