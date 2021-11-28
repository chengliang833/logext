package top.ulane.logext.properties;

import java.util.Properties;

public class LogextProperties {
	
	private static Properties properties;

	public static void initProperties(Properties properties){
		LogextProperties.properties = properties;
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue){
		return properties.getProperty(key, defaultValue);
	}
	
}
