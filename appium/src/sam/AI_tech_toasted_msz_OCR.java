package sam;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class AI_tech_toasted_msz_OCR 
{

	public static void main(String[] args) throws Exception
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "374a63b0");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.4.2");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
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
		//Automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Contacts']")));
			driver.findElement(By.xpath("//*[@text='Contacts']")).click();
			//swipe from bottom to top for required contact
			driver.context("NATIVE_APP");
			int wd=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			TouchAction ta=new TouchAction(driver);
			int x1=(int)(wd/2);
			int y1=(int)(h*0.8);//near to bottom
			int x2=(int)(wd/2);
			int y2=(int)(h*0.4);//near  to center from top
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Best Offers']")).click();
					break;
				}
			catch(Exception ex)
				{
				ta.press(x1,y1).waitAction(Duration.ofMillis(5000)).moveTo(x2,y2).release().perform();
				}
			}
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'actions_view_container')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'actions_view_container')]")).click();
			Thread.sleep(3000);//wait for toasted msg visibility
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("appscreen.png");
			FileUtils.copyFile(src,dest);
			//click end call
			driver.findElement(By.xpath("//*[contains(@resource-id,'endButton')]")).click();
			//driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.phone:id/endButton\")").click();
			//Load Tessdata file which have charactors
			File fo=LoadLibs.extractTessResources("tessdata");
			//create object to apply OCR on image
			Tesseract obj=new Tesseract();
			obj.setDatapath(fo.getAbsolutePath());
			String result=obj.doOCR(dest);
			Thread.sleep(20000);
			System.out.println(result);
			if(result.contains("Conditional call forwarding active"))
			{
				System.out.println("toasted message test passed");
			}
			else
			{
				System.out.println("Toasted message test failed");
			}
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
