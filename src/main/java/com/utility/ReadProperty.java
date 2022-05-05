package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	public static String getPropertyValue(String key) {
		FileReader reader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir")+"/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	      
	    Properties p=new Properties();  
	    try {
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}  
	    return p.getProperty(key);  
	}

	public static void setPropertyValue(String key, String value) throws Exception {
		FileInputStream in = new FileInputStream("config.properties");
		Properties props = new Properties();
		props.load(in);
		in.close();
		FileOutputStream out = new FileOutputStream("config.properties");
		props.setProperty(key, value);
		props.store(out, null);
		out.close();
	}
}
