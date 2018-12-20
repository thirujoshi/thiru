package sam;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Drog_and_Drop 
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
	//back to home
	driver.pressKeyCode(AndroidKeyCode.HOME);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@text='VodQAReactNative']")).click();
	//Automation
	try
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag & Drop']")));
		driver.findElement(By.xpath("//*[@text='Drag & Drop']")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag me!']")));
		WebElement e1=driver.findElement(By.xpath("//*[@text='Drag me!']"));
		WebElement e2=driver.findElement(By.xpath("//*[@text='Drop here.']"));
		TouchAction ta=new TouchAction(driver);
		Duration d=Duration.of(10,ChronoUnit.SECONDS);
		ta.press(e1).waitAction(d).moveTo(e2).release().perform();
		try
		{
			if(driver.findElement(By.xpath("//*[@text='Circle dropped']")).isDisplayed())
			{
				System.out.println("Operation was finished");
			}
			else
			{
				System.out.println("Operation was not finished");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//close app
		driver.closeApp();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	//stop appium server
	Runtime.getRuntime().exec("taskkill /F /Im node.exe");
	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	
	}
	}

			
	
