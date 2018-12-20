package sam;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class moble_or_computer_mercuri_tours_app_browser_testing 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter platform as computer/mobile");
		String p=sc.nextLine();
		WebDriver driver=null;
		if(p.equalsIgnoreCase("computer"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\java258\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			//provide device details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName", "374a63b0");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","4.4.2");
			//start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4445\"");
			URL u=new URL("http://0.0.0.0:4445/wd/hub");
			//creat driver object
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
			//Launch site
			driver.get("http://www.newtours.demoaut.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}

}
