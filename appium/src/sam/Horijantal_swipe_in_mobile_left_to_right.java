package sam;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Horijantal_swipe_in_mobile_left_to_right 
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
		
		
			if(driver.findElement(By.xpath("//*[@text='OK']")).isDisplayed());
			{
				driver.findElement(By.xpath("//*[@text='OK']")).click();
				
			}
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='Apps']")).click();
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='WhatsApp']")).click();
					break;
				}
				catch(Exception ex)
				{
					TouchAction ta=new TouchAction(driver);
					driver.context("NATIVE_APP");
					int w=driver.manage().window().getSize().getWidth();
					int h=driver.manage().window().getSize().getHeight();
					//swipe from right to left
					int x1=(int)(w*0.9);//near to right edge
					int y1=(int)(h/2);
					int x2=(int)(w*0.7);//near to center
					int y2=(int)(h/2);
					{
						Duration d=Duration.of(5, ChronoUnit.SECONDS);
						ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
						
						for(int i=0;i<4;i++)
						{
							driver.findElement(By.xpath("//*[@text='0']")).click();
						}
					}
					
					
					
				}
				
			}
			
			{
			}
		}
			
			}



