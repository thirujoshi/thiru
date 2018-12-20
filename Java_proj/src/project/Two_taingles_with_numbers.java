package project;

public class Two_taingles_with_numbers 
{
	public static void main(String[] args) 
	{
		int no=1;
		for(int i=1;i<=10;i++)
		{
			for(int k=9;k>=i;k--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print(no+" ");
				no=no+1;
			}
				for(int l=1;l<i;l++)
				{
					System.out.print(no+" ");
					no=no-1;
				}
			System.out.println();
		}

	}

	}
