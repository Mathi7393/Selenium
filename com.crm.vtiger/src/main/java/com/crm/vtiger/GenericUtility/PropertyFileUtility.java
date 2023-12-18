package com.crm.vtiger.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consist of generic method to fetch data from Property File
 * 
 * @author mathi
 * @mathi
 */
public class PropertyFileUtility {
	/**
	 * This method help us to fetch data from property file
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant1.propertyfilepath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
