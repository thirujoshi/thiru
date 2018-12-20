package sam;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class VodQa_vertical_horizantal_get_text
{
	public static void main(String[] args) throws Exception
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "374a63b0");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.4.2");
		dc.setCapability("appPackage","com.tricolorcat.calculator");
		dc.setCapability("appActivity","com.tricolorcat.calculator.MainActivity");
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
	//Back to menu
		try
		{
		if(driver.findElement(By.xpath("//*[@text='OK']")).isDisplayed());
		{
			driver.findElement(By.xpath("//*[@text='OK']")).click();
			
		}
		driver.pressKeyCode(AndroidKeyCode.HOME);
		//driver.pressKeyCode(AndroidKeyCode.MENU);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@resource-id,'home_allAppsIcon')]")).click();
		TouchAction ta=new TouchAction(driver);
		ta.press(600,1075).moveTo(-280,0).release().perform();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	}
		
		
