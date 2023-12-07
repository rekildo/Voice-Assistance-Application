package com.rekildo.voice;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceAssistant {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		//language(en) - hard coded value
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\main\\resource\\6405.dic");
		config.setLanguageModelPath("src\\main\\resource\\6405.lm");
		
		
		
		try {
			//this will take the things that we speak through our mic
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
			
			//capturing the voice command 
			while((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is : " + voiceCommand);
				
				if(voiceCommand.equalsIgnoreCase("open chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");
				}else if(voiceCommand.equalsIgnoreCase("close chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}else if(voiceCommand.equalsIgnoreCase("open youtube")) {
					Runtime.getRuntime().exec("cmd.exe /c start www.youtube.com");
				}else if(voiceCommand.equalsIgnoreCase("close youtube")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}else if(voiceCommand.equalsIgnoreCase("open paint")) {
					Runtime.getRuntime().exec("cmd.exe /c start mspaint");
				}else if(voiceCommand.equalsIgnoreCase("close paint")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM mspaint.exe");
				}else if(voiceCommand.equalsIgnoreCase("play music")) {
					Runtime.getRuntime().exec("cmd.exe /c start https://www.youtube.com/watch?v=xvFZjo5PgG0");
				}else if(voiceCommand.equalsIgnoreCase("stop music")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe ");
				}else if(voiceCommand.equalsIgnoreCase("open excel")) {
					Runtime.getRuntime().exec("cmd.exe /c start excel");
				}else if(voiceCommand.equalsIgnoreCase("close excel")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM excel.exe ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
