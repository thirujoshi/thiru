package sam;

import java.util.HashSet;
import java.util.Set;

public class Duplicate4 {

	public static void main(String[] args) {
		String[] a={"1","1","2","3","4","2"};
		Set<String> b=new HashSet<>();
		for(String name : a)
		{
			if(b.add(name)==false)
			{
				System.out.println("Duplicate number: "+name);
			}
		}
		

	}

}
