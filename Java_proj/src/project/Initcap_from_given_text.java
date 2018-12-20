package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Initcap_from_given_text 
{
	public static void main(String[] args) 
	{
		String x="Test Automation code ";
		Pattern p=Pattern.compile("[A-Z][a-z]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}
		

	}

}
