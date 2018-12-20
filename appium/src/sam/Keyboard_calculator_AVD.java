package sam;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Keyboard_calculator_AVD
{
public static void main(String[] args) throws Exception
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter input1");
	String x=sc.nextLine();
	System.out.println("enter input2");
	String y=sc.nextLine();
	Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4445\"");
	URL u=new URL("http://0.0.0.0:4445/wd/hub");
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME,"");
	dc.setCapability("deviceName", "emulator-5554");
	dc.setCapability("platformName","android");
	dc.setCapability("platformVersion","4.2.2");
	dc.setCapability("appPackage","com.android.calculator2");
	dc.setCapability("appActivity","com.android.calculator2.Calculator");	
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
	for(int i=0;i<x.length();i++)
	{
		char c=x.charAt(i);
		driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
	}
	
	driver.findElement(By.xpath("//*[@text='+']")).click();
	for(int i=0;i<y.length();i++)
	{
		char c=y.charAt(i);
		driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
	}
	driver.findElement(By.xpath("//*[@text='=']")).click();
	
}
catch(Exception e)
{
	System.out.println(e);
}
driver.closeApp();
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	
}

}
