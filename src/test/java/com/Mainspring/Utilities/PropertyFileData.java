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
		this.ObjectPropertyFilePath = "./src/test/resources/Object Repository/ObjectRepo.properties";
	}

	public Properties getPropertyData(String propFilePath) throws IOException
	{
		File file=null;
		FileInputStream fi;
		Properties prop;
		
		if(propFilePath.equals("AutomationConfig"))
		{
			file= new File(automationPropertyFilePath);
		}
		else if(propFilePath.equals("ObjectRepo"))
		{
			file= new File(ObjectPropertyFilePath);
		}
		fi= new FileInputStream(file);
		prop = new Properties();
		prop.load(fi);
		return prop;
	}
}
