package project;

import java.util.Scanner;

public class Fibanacci2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a limit");
		int x=1;
		int y=1;
		int m=sc.nextInt();
		int z=x+y;
		System.out.print(x+" "+y+" ");
		 while(z<=m)
		{
			x=y;
			y=z;
			z=x+y;
		System.out.print(z+" ");
		}

	}

}
