package project;

public class Substring 
{

	public static void main(String[] args) 
	{
		/*String x="a:bhjkhkj?16lnhg";
		String y=x.substring(3,x.length()-3);
		System.out.println(y);*/
		
		String x="a:bhjkhkm?165lnhg";
		String y[]=x.split("j");
		String z[]=y[1].split("n");
		System.out.println(z[0]);		

	}

}
