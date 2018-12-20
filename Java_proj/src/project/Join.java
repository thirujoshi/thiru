package project;

import java.util.ArrayList;

public class Join 
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<String> x=new ArrayList<String>();
		x.add("Amar");
		x.add("akber");
		x.add("Antony");
		String z="";
		String y=z.join(" ",x);
		System.out.println(y);
	}
}