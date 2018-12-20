package project;

public class Reverse_number 
{
	public static void main(String[] args)
	{
		int x=54866;
		int y=0;
		/*do
		{
			int d=x%10;
			y=y*10+d;
			x=(int)x/10;
		}while(x!=0);*/
		while(x>0)
		{
			int d=x%10;
			y=y*10+d;
			x=x/10;
		}
		System.out.println(y);
		if(x==y)
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not palindrome");	
		}
	}

}
