package project;

import java.util.Scanner;

public class Prime_number 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		float x=sc.nextFloat();
		float flog=0;
		for(int i=2;i<x;i++)
		{
			if(x%i==0)
			{
				flog=1;
			}
		}
			if(flog==0)
			{
				System.out.println(x+ "Is prime number");
			}
			else
			{
				System.out.println(x+ "is not prime number");
			}
	}

}
