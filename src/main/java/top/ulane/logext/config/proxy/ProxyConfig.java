package top.ulane.logext.config.proxy;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;
import top.ulane.logext.properties.LogextProperties;
import wang.ulane.proxy.MethodParam;
import wang.ulane.proxy.ProxyClass;
import wang.ulane.proxy.ProxyClassLog;

@ConditionalOnProperty(value="logext.proxy.enable", havingValue="true")
public class ProxyConfig {
	
	static {
		ProxyClass.initClass("properties/app.properties", "logext.proxys.initclass");
		Map<String, List<MethodParam>> map = ProxyClass.getMethodList("properties/app.properties", "logext.proxys.list");
		filterStart(map, "logext.proxy.http", "logext.proxys.list.default_httpproxy");
		ProxyClassLog.proxyMethodLog(map);
	}
	
	public static void filterStart(Map<String, List<MethodParam>> map, String switchKey, String valueKey){
		if(!"true".equals(LogextProperties.getProperty(switchKey))){
			map.remove(valueKey);
		}
	}
	
//	@Bean
//	@ConditionalOnProperty(value="logext.proxy.http", matchIfExist=true)
//	public HttpProxyAop httpProxyAop(){
//		return new HttpProxyAop();
//	}
	
}
