package project;

public class Test5
{

	public static void main(String[] args) 
	{
		//creat abject to abstract class
		Sample8 obj1=new Sample9();
		int a=obj1.add(10,20);
		int b=obj1.subtract(10,20);
		//creat object to concrete class
		Sample9 obj2=new Sample9();
		int c=obj2.add(40,50);
		int d=obj2.subtract(40,50);

	}

}
