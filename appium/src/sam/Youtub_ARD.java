package sam;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Youtub_ARD
{

	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4445\"");
		URL u=new URL("http://0.0.0.0:4445/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "374a63b0");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.4.2");
		dc.setCapability("appPackage","com.google.android.youtube");
		dc.setCapability("appActivity","com.google.android.apps.youtube.app.WatchWhileActivity");
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
			driver.get("http://www.youtube.com");
			WebDriverWait w=new WebDriverWait(driver,50);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Search']")));
			driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
	
			driver.findElement(By.xpath("//*[@index='1']")).sendKeys("abdul kalam speech",Keys.ENTER);
			
			
			
	}

}
