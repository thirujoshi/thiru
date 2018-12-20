package sam;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Get_remote_address 
{
public static void main(String[] args) throws Exception
{
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME,"");
	dc.setCapability("deviceName", "374a63b0");
	dc.setCapability("platformName","android");
	dc.setCapability("platformVersion","4.4.2");
	dc.setCapability("locationServicesEnabled",true);
	dc.setCapability("locationServicesAuthorized",true);
	dc.setCapability("appPackage","com.google.android.apps.maps");
	dc.setCapability("appActivity","com.google.android.maps.MapsActivity");
	Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4445\"");
	URL u=new URL("http://0.0.0.0:4445/wd/hub");
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
     String x=driver.getRemoteAddress().getPath();
     System.out.println(x);
     String y=driver.getRemoteAddress().getProtocol();
     System.out.println(y);
     int z=driver.getRemoteAddress().getPort();
     System.out.println(z);
     String h=driver.getRemoteAddress().getHost();
     System.out.println(h);
     String s=driver.getDeviceTime();
     System.out.println(s);
     String p=driver.getPlatformName();
     System.out.println(p);
     driver.openNotifications();
     WebDriverWait wait=new WebDriverWait(driver,100);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='System settings']")));
     driver.findElement(By.xpath("//*[@content-desc='System settings']")).click();
    		 
}
}
	


