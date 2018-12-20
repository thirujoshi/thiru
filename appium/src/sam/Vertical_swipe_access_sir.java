package sam;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Vertical_swipe_access_sir 
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
		//Automation
			try
			{
				if(driver.findElement(By.xpath("//*[@text='OK']")).isDisplayed());
				{
					driver.findElement(By.xpath("//*[@text='OK']")).click();
					
				}
				driver.pressKeyCode(AndroidKeyCode.HOME);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='VodQAReactNative']")).click();
				WebDriverWait wait=new WebDriverWait(driver,100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
				driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
				while(2>1)
				{
					try
					{
						driver.findElement(By.xpath("//*[@text='Web View']")).click();
						break;
					}
					catch(Exception e)
					
					{
						TouchAction ta=new TouchAction(driver);
						//driver.context("NATIVE_APP");
						int w=driver.manage().window().getSize().getWidth();
						int h=driver.manage().window().getSize().getHeight();
						int x1=w/2;
						int y1=(int)(h*0.9);
						int x2=w/2;
						int y2=(int)(h*0.4);
						Duration d=Duration.of(10,ChronoUnit.SECONDS);
						ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
						
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='5.']/following-sibling::*[2]")));
				String x=driver.findElement(By.xpath("//*[@content-desc='5.']/following-sibling::*[2]")).getAttribute("content-desc");
				System.out.println(x);
				driver.closeApp();
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				
			}

	}

}
