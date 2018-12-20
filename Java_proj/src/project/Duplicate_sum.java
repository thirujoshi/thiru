package project;

public class Duplicate_sum 
{
public static void main(String[] args) 
{
	int a[]={1,2,3,4,5,6};
	int b[]={4,5,6,7,8,9};
	int z=0;
	for(int i=0;i<a.length;i++)
	{
		for(int j=0;j<b.length;j++)
		{
			if(a[i]==b[j])
			{
				System.out.print("Duplicate numbers:" +a[i]);
				z=z+a[i];
				System.out.println("sum of duplicate value:" +z);
			}
				
		}
		
	}
	
	}

}
