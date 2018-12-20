package project;

import java.util.Scanner;

public class Duplicate2 {

	public static void main(String[] args)
	{
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Eneter numbers");
//		int x=sc.nextInt();
		int obj[]={1,2,3,1,4,5,4,6,7,6,8};
		for(int i=0;i<obj.length;i++)
		{
			for(int j=i+1;j<obj.length;j++)
			{
				if(obj[i]==obj[j])
				{
					System.out.println("Duplicate numbers" +obj[j]);
				}
			}
		}

	}

}
