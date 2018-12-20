package project;

import java.util.Scanner;

public class Switchcase {

	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter number");
	int u=sc.nextInt();
	String dayString="";
	switch(u)
	{
	case 1:
		dayString="one";
		break;
	case 2:
		dayString="two";
		break;
	case 3:
		dayString="three";
		break;
	case 4:
		dayString="four";
		break;
	}
	System.out.println(dayString);

	}

}
