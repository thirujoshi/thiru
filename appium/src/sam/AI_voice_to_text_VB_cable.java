package sam;

import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AI_voice_to_text_VB_cable 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter text");
		String x=sc.nextLine();
		//launch google site
		System.setProperty("webdriver.chrome.driver","E:\\java258\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gsri_ok0']")));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='gsri_ok0']")).click();
		Thread.sleep(1500);//ready for listening
		//convert given text to voice
		System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		//Register Engine
		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		//ceate a synthesizer
		Synthesizer s=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		//allocate synthesizer
		s.allocate();
		//resume synthesizer
		s.resume();
		//speak the given text until queue empty
		s.speakPlainText(x,null);
		s.waitEngineState(Synthesizer.QUEUE_EMPTY);
		//deallocate the synthesizer
		s.deallocate();
		//validate result
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resultStats']")));
		String y=driver.getTitle();
		x=x.toLowerCase();
		y=y.toLowerCase();
		if(y.contains(x))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		//close sit
		driver.close();
		}
		}
		

