package sam;

import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class AI_text_to_voice 
{
public static void main(String[] args)throws Exception
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter text");
	String x=sc.nextLine();
	//set properties as kevin dictionary
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
	}

}
