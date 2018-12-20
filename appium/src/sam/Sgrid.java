package sam;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sgrid {

	public static void main(String[] args) throws Exception
	{
		URL u=new URL("http://192.168.43.93:5566/wd/hub");
		FirefoxOptions dc=new FirefoxOptions();
		WebDriver driver=new RemoteWebDriver(u,dc);
		driver.get("https://www.google.co.in");
		driver.close();

	}

}
