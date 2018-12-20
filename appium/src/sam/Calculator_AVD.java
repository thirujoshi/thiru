package sam;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Calculator_AVD 
{
	public static void main(String[] args) throws Exception
	{
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
		driver.findElement(By.xpath("//*[@text='3']")).click();
		driver.findElement(By.xpath("//*[@text='9']")).click();
		driver.findElement(By.xpath("//*[@text='6']")).click();
		driver.findElement(By.xpath("//*[@text='×']")).click();
		driver.findElement(By.xpath("//*[@text='5']")).click();
		driver.findElement(By.xpath("//*[@text='=']")).click();
		//String x=driver.findElement(By.xpath("//*[@clickable='true']")).getAttribute("text");
		//System.out.println(x);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
	}
}

