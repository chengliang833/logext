package top.ulane.logext.config.dubbo;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import top.ulane.logext.properties.LogextProperties;

public class DubboLogLevel {
	
	//log4j优先加载，启动时无法修改，不做集成，手动改配置文件吧
//	static {
//		Properties properties = null;
//		try {
//			properties = PropertiesLoaderUtils.loadAllProperties("log4j.properties");
//			properties.putAll(PropertiesLoaderUtils.loadAllProperties("properties/log4j.properties"));
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("properties:"+properties);
//		if(properties != null && properties.size() > 0 && !properties.containsKey("log4j.logger.com.alibaba.dubbo")){
//			String level = LogextProperties.getProperty("logext.dubbo.log.level");
//			properties.put("log4j.logger.com.alibaba.dubbo", level == null ? "ERROR" : level);
//			System.out.println(properties.getProperty("log4j.logger.com.alibaba.dubbo"));
//			PropertyConfigurator.configure(properties);
//		}
//	}
	
}
