package sam;

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

public class Zoom_using_tap_concept_ARD 
{
public static void main(String[] args) throws Exception
	{
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME,"");
	dc.setCapability("deviceName", "32308f0953e070f9");
	dc.setCapability("platformName","android");
	dc.setCapability("platformVersion","4.4.2");
	dc.setCapability("appPackage","com.sec.android.app.popupcalculator");//com.tricolorcat.calculator
	dc.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");//com.tricolorcat.calculator.MainActivity
	//start appium server
	Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
	URL u=new URL("http://0.0.0.0:4723/wd/hub");
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
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Photo View']")).click();
					break;
				}
				catch(Exception e)				
				{
				
					TouchAction ta=new TouchAction(driver);
					driver.context("NATIVE_APP");
					int wd=driver.manage().window().getSize().getWidth();
					int h=driver.manage().window().getSize().getHeight();
					int x1=wd/2;
					int y1=(int)(h*0.9);
					int x2=wd/2;
					int y2=(int)(h*0.4);
					Duration d=Duration.of(10,ChronoUnit.SECONDS);
					ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
				}
							
			}
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ImageView']")));
			
			WebElement e=driver.findElement(By.xpath("//*[@class='android.widget.ImageView']"));
			TouchAction a1=new TouchAction(driver);
			a1.tap(e);
			TouchAction a2=new TouchAction(driver);
			a2.waitAction(Duration.ofMillis(5)).tap(e);
			MultiTouchAction ma=new MultiTouchAction(driver);
			ma.add(a1).add(a2).perform();
			
	}
	catch(Exception ex)		
	{
							
		
	}
					
	}
}
