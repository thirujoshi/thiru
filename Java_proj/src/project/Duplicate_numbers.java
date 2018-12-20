package project;

public class Duplicate_numbers 
{
public static void main(String[] args)
{
	int obj[]={1,1,3,5,5,6,9,9,9};
	for(int i=0;i<obj.length;i++)
	{
		for(int j=i+1;j<obj.length;j++)
		{
			if(obj[i]==obj[j])

		{
			System.out.println("duplicate number" +obj[j]);	
		}
		}
	}

}
}
