package sam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AI_tech_color_recognization_vodQa 
{
	public static void main(String[] args) throws Exception
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter red/green/black/blue");
	String cname=sc.nextLine();
	int count=0;
	int percentage;
	Color ec=null;
	switch(cname)
	{
	case "black":
		ec=Color.BLACK;
		break;
	case "red":
		ec=Color.RED;
		break;
	case "blue":
		ec=Color.BLUE;
		break;
	case "green":
		ec=new Color(0,128,0);
		break;
	default:
		System.out.println("Wrong color");
		System.exit(0);//stop execution forcibly
	}
	//Details of ARD and APP
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
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			//Swipe for wheel picker option
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
					break;
				}
				catch(Exception ex)
				{
					TouchAction ta=new TouchAction(driver);
					driver.context("NATIVE_APP");
					int w=driver.manage().window().getSize().getWidth();
					int h=driver.manage().window().getSize().getHeight();
					int x1=(int)(w/2);
					int y1=(int)(h*0.9);
					int x2=(int)(w/2);
					int y2=(int)(h*0.4);
					ta.press(x1,y1).moveTo(x2,y2).release().perform();
				}
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Spinner']")));
			driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ListView']")));
			driver.findElement(By.xpath("//*[@text='"+cname+"']")).click();
			WebElement e=driver.findElement(By.xpath("//*[@bounds='[0,162][720,262]']"));
			//Get the location of element on the app screen
			int x=e.getLocation().getX();
			int y=e.getLocation().getY();
			//get width and height of the element
			int eleWidth=e.getSize().getWidth();
			int eleHeight=e.getSize().getHeight();
			//get entire page screenshot
			File Screenshot=driver.getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg=ImageIO.read(Screenshot);
			//crop the full screenshot to get element screenshot
			BufferedImage eleScreenshot=fullImg.getSubimage(x,y,eleWidth,eleHeight);
			//check image color to validate.
			for(int i=0;i<eleWidth;i++)
			{
				for(int j=0;j<eleHeight;j++)
				{
					Color ac=new Color(eleScreenshot.getRGB(i,j));
					if(ac.getRed()==ec.getRed()&& ac.getBlue()==ec.getBlue() && ac.getGreen()==ec.getGreen())
					{
						count=count+1;
					}
				}
			}
			System.out.println(count);
			percentage=(count*100)/(eleWidth*eleHeight);
			if(percentage>=85)
			{
				System.out.println("color test was passed");
			}
			else
			{
				System.out.println("color test was failled");
			}
			//close app
			driver.closeApp();
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
			
