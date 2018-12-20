package sam;

import java.net.URL;
import java.time.Duration;

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

public class Double_tap_vodQa_ARD
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
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap']")));
			driver.findElement(By.xpath("//*[@text='Double Tap']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap Me']")));
			WebElement e=driver.findElement(By.xpath("//*[@text='Double Tap Me']"));
			//double tap
			TouchAction a1=new TouchAction(driver);
			a1.tap(e);
			TouchAction a2=new TouchAction(driver);
			a2.waitAction(Duration.ofMillis(10)).tap(e);
			MultiTouchAction ma=new MultiTouchAction(driver);
			ma.add(a1).add(a2).perform();
			try
			{
				if(driver.findElement(By.xpath("//*[@text='Double tap successful!']")).isDisplayed())
				{
					System.out.println("operation was finished");
					}
				else
				{
					System.out.println("operation was not finished");
					}
			}
			catch(Exception ex)
			{
				System.out.println("operation was not finished");
				
			}
				// close app
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			}
		
		//stop appium
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
