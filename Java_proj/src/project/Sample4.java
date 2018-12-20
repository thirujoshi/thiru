package project;

public class Sample4
{
	//Data members
	public int x;
	public float y;
	public char z;
	public boolean w;
	public String s;
	//method
	public Sample4()//constructor method
	{
		x=50;
		s="thiru";
		z='A';
		
	}
	public Sample4(String temp)//constructor method
	{
		x=40;
		s=temp;
	}
	public void display()//operational method
	
	{
		System.out.println( x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(w);
		System.out.println(s);
	}

}
