package project;

import java.util.Scanner;

public class Foctorial_series {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		int i,fact=1;
		int y=sc.nextInt();
		
		for(i=1;i<=y;i++)
		{
			fact=fact*i;
			
		}
		System.out.println("factorial of +y+ is:"+fact);

	}

}
