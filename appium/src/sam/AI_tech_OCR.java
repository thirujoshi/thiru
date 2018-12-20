package sam;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class AI_tech_OCR 
{

	public static void main(String[] args) throws Exception
	{
		//Load tessdata folder which have charscters in various font
		File fo=LoadLibs.extractTessResources("tessdata");
		//create object to apply OCR on image
		Tesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());//src
		//take screenshot file,which have text in content
		File f=new File("E:\\manual.PNG");
		String result=obj.doOCR(f);
		Thread.sleep(20000);
		System.out.println(result);
		
	}

}
