package project;

import java.util.Scanner;

public class Reverse_String
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enete a word");
		String x=sc.nextLine();
		String y="";
		for(int i=x.length()-1;i>=0;--i)
		{
			char c=x.charAt(i);
			y=y+c;
			
		}
		System.out.println(y);
		if(x.equals(y))
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not palindrome");
		}
	}

}
