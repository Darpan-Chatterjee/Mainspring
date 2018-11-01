package com.Mainspring.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileData {
	
	String automationPropertyFilePath;
	String ObjectPropertyFilePath;
	
	public PropertyFileData() {
		this.automationPropertyFilePath = "./src/test/resources/Manager/AutomationConfig.properties";
		this.ObjectPropertyFilePath = "./src/test/resources/Object Repository/";
	}
	
	public String getPropertyData(String propFilePath,String fieldName) throws IOException
	{
		File file=null;
		FileInputStream fi;
		Properties prop;
		
		if(propFilePath.equals("AutomationConfig"))
		{
			file= new File(automationPropertyFilePath);
		}
		else
		{
			file= new File(ObjectPropertyFilePath+propFilePath+".properties");
		}
		fi= new FileInputStream(file);
		prop = new Properties();
		prop.load(fi);
		return prop.getProperty(fieldName);
	}
}
