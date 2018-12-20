package project;

public class Split
{
	public static void main(String[] args) 
	{
		String x="thiru,is,a,good,boy";
		String y[]=x.split(",");
		System.out.println(y.length);
		for(int i=0; i<y.length; i++)
		{
			System.out.println(" "+y[i]);
		}

	}

}
