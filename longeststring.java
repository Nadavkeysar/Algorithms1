
public class longeststring {
public static void len(String k)
{ int place;
	
	int index=0; String res= "";
	int index2=0;
	int max=0;
	String tmp="";
	String tmp2="";

	while(index<k.length())
		
	{
		char y= k.charAt(index);
		index2=index+1;
		index2=k.indexOf(y,index2);
		if(index2!=-1)
		{
			 tmp= k.substring(index,index2);
			if(tmp.length()>max)
			{
				max=tmp.length();
				tmp2=tmp;
				res="";
			}
			index=index2;

			
			
		}
		
		else
		{
			res=res+y;
			index++;
			if(res.length()>max)
			{
				max=res.length();
				tmp2=res;
}
			
		}
		
			
	}
		
	System.out.print("string is : "+tmp2+"  length is : "+ max);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String k="bbbbb";
   len(k);
	}

}
