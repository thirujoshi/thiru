package sam;

import java.util.Scanner;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Joshiappium1 
{

	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter phone number");
	String x=sc.nextLine();
	
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME,"");
	dc.setCapability("deviceName","374a63b0");
	dc.setCapability("platformName","android");
    dc.setCapability("platformVersion","4.2.2");
    //	dc.setCapability("appPackage",);
	
	}
}
