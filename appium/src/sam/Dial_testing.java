package sam;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Dial_testing
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone nomber");
		String x=sc.nextLine();
		//details of ARD and APP
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "374a63b0");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.4.2");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4445\"");
		URL u=new URL("http://0.0.0.0:4445/wd/hub");
		//creat driver object
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
		//locate and operate elements
		try
		{
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			//Dial number
			for(int i=0;i<x.length();i++)
			{
				char c=x.charAt(i);
				String y="";
				switch(c)
				{
				case'0':
					y="Zero";
					break;
				case'1':
					y="One";
					break;
				case'2':
					y="Two";
					break;
				case'3':
					y="Three";
					break;
				case'4':
					y="Four";
					break;
				case'5':
					y="Five";
					break;
				case'6':
					y="Six";
					break;
				case'7':
					y="Seven";
					break;
				case'8':
					y="Eight";
					break;
				case'9':
					y="Nine";
					break;	
				}
				//driver.findElement(By.xpath("//*[contains(@resource-id,'"+y+"')]")).click();
				driver.findElement(By.xpath("//*[@content-desc='"+y+"']")).click();
			}
			//call using SIM 1
			driver.findElement(By.xpath("//*[@content-desc='SIM 1 Call']")).click();
			Thread.sleep(20000);
	//call lifted or not
		try
		{
			if(driver.findElement(By.xpath("//*[@text='Dialling']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[contains(@resource-id,'endButton')]")).click();
			}
		}
		catch(Exception ex)
		{
			driver.findElement(By.xpath("//*[contains(@resource-id,'endButton')]")).click();
			Thread.sleep(5000);
			//driver.findElementByAndroidUIAutomator("new UiSelector().text(\"End call\")").click();
			String m=driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text");	
			System.out.println(m);
			driver.findElement(By.xpath("//*[@text='OK']")).click();
		}
		driver.closeApp();
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
		//stop appium
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}
	}



	


