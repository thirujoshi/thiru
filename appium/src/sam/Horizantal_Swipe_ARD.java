package sam;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Horizantal_Swipe_ARD 
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
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();	
				driver.findElement(By.xpath("//*[@text='Slider']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='slider']")));
				WebElement e1=driver.findElement(By.xpath("//*[@content-desc='slider']"));
				Duration d=Duration.of(10,ChronoUnit.SECONDS);
				int e1x1=e1.getLocation().getX();
				int e1y1=e1.getLocation().getY();
				int e1x2=e1x1+200;
				int e1y2=e1y1;
				TouchAction ta1=new TouchAction(driver);
				ta1.press(e1x1,e1y1).moveTo(e1x2,e1y2).release().perform();
				WebElement e2=driver.findElement(By.xpath("//*[@content-desc='slider1']"));
				int e2x1=e2.getLocation().getX();
				int e2y1=e2.getLocation().getY();
				int e2x2=e2x1+200;
				int e2y2=e2y1;
				TouchAction ta2=new TouchAction(driver);
				ta2.press(e2x1,e2y1).moveTo(e2x2,e2y2).release().perform();
				MultiTouchAction mta=new MultiTouchAction(driver);
				mta.add(ta1).add(ta2).perform();
				
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
				
				
				
				

	}

}
