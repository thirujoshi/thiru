package project;

public class Duplicate3
{
public static void main(String[] args) 
{
	String obj[]={"thiru","thiru","fine"};
	for(int i=0;i<obj.length;i++)
	{
		for(int j=i+1;j<obj.length;j++)
		{
			if(obj[i]==obj[j])

		{
			System.out.println("duplicate name: " +obj[j]);	
		}
		}
	}
	
	   
	}

}
