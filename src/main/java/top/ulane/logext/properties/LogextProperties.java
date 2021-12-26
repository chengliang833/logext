package top.ulane.logext.properties;

import java.util.Properties;

public class LogextProperties {
	
	private static Properties properties;

	public static void initProperties(Properties properties){
		LogextProperties.properties = properties;
	}
	
	public static String getProperty(String key){
		checkProperties();
		return properties.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue){
		checkProperties();
		return properties.getProperty(key, defaultValue);
	}
	
	private static void checkProperties(){
		if(properties == null){
			throw new RuntimeException("UlaneAutoConfigurationImportSelector 未加载");
		}
	}
}
