package sam;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Launch_one_App_to_change_to_other_App 
{

	public static void main(String[] args)throws Exception
	{
 //Details of ARD and phone App
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
		try
		{
			//back to home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(10000);
			//go to other app and operate element
			driver.findElement(By.xpath("//*[@content-desc='Applications']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@text='WordPress']")).click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			if(driver.isKeyboardShown())
			{
				driver.hideKeyboard();
			}
			driver.findElement(By.xpath("//*[@text='Log In']")).click();
			//back to home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			//launch phone app and close
			driver.launchApp();
			driver.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
}