package sam;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Call_to_number_ARD
{
public static void main(String[] args) throws Exception
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter phone number");
	String x=sc.nextLine();
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME,"");
	dc.setCapability("deviceName", "374a63b0");
	dc.setCapability("platformName","android");
	dc.setCapability("platformVersion","4.2.2");
	dc.setCapability("appPackage","com.android.contacts");
	dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
	Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4445\"");
	URL u=new URL("http://0.0.0.0:4445/wd/hub");
	AndroidDriver driver;
	while(2>1)
	{
		try
		{
			driver=new AndroidDriver(u,dc);
			break;
		}
		catch(Exception e)
		
		{
			
		}
	}
	try
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    for(int i=0;i<x.length();i++)
	{
		char c=x.charAt(i);
		String y="";
		switch(c)
		{
		case '0':
			y="Zero";
			break;
		case '1':
			y="One";
			break;
		case '2':
			y="Two";
			break;
		case '3':
			y="Three";
			break;
		case '4':
			y="Four";
			break;
		case '5':
			y="Five";
			break;
		case '6':
			y="Six";
			break;
		case '7':
			y="Seven";
			break;
		case '8':
			y="Eight";
			break;
		case '9':
			y="Nine";
			break;	
		}
	driver.findElement(By.xpath("//*[contains(@resource-id,'"+y+"')]")).click();
	}}
	catch(Exception ex)
	{
		System.out.println(ex.getLocalizedMessage());
	}
	
	}
}

	

