package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Charactor_count_string 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//String x="steve jobs";
		System.out.println(x.length());
		//int cnt=0;
		for(int i=0; i<x.length(); i++)
		{
			char c = x.charAt(i);
			System.out.println(c+" ");
				
		}
			
		}
		

	

}
