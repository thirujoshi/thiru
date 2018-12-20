package sam;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Calcu_testing {

	public static void main(String[] args) throws Exception
	{
		// Launch Calculator app in AVD (Andriod Vartual Device) 
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","andriod");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
        URL u=new URL("http://0.0.0.0:4723/wd/hub");
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
        	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        	driver.findElement(By.xpath("//*[@text='9']")).click();
        	//driver.findElement(By.xpath("//*[@clickable='true']")).click();
        	driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
        	driver.findElement(By.xpath("//*[@text='8']")).click();
        	driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
        
        	}
        catch(Exception e)
            {
        	System.out.println(e.getMessage());
        }
      }
	}


	


