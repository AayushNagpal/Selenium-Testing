package com.pack.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class GrabPropertyValue {
	
	// Grabing log4j file
	static Logger log = Logger.getLogger("GrabPropertyValue");
	
	protected static Properties prop =null;
	protected InputStream input = GrabPropertyValue.class.getClassLoader().getResourceAsStream("data/config.properties");
	protected InputStream createAcc = GrabPropertyValue.class.getClassLoader().getResourceAsStream("data/createAccountValue.properties");
	protected InputStream oRepo = GrabPropertyValue.class.getClassLoader().getResourceAsStream("data/objectRepository.properties");
    		
    		
    //defaut constructer		
	public GrabPropertyValue() throws IOException{		
		log.info("Retrieving values from config properties file");
		prop = new Properties();
		prop.load(input);
		}
	
	// Will be called to access createAccount and Object Repository config files
	public GrabPropertyValue(String file) throws IOException{
		if(file=="createAcc")
		{
			log.info("Retrieving values from create Account properties file");
			prop = new Properties();
			prop.load(createAcc);			
		}
		else
			{
			log.info("Retrieving values from object Repository properties file");
			prop = new Properties();
			prop.load(oRepo);
			
			}
		}
	//retrieves value of key in string format
	public static String getValueOf(String key)
	{
		String value = prop.getProperty(key).trim();
		log.info("Value of " +key+" is "+ value);
		return value;
	}
	
	//retrieves value of key in int format
	public static int getWaitTime(String key)
	{
		String value = prop.getProperty(key).trim();
		int wait = Integer.parseInt(value);
		log.info("Wait Time is "+ wait);
		return wait;
	}
}
