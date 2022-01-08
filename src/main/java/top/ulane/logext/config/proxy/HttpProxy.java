package top.ulane.logext.config.proxy;

import java.util.List;
import java.util.Map;

import top.ulane.logext.properties.LogextProperties;
import wang.ulane.proxy.MethodParam;

public class HttpProxy {

	public static final String host = LogextProperties.getProperty("logext.proxy.httpproxy.host");
	public static final Integer port;
	public static final boolean isProxy;
	
	static {
		String portStr = LogextProperties.getProperty("logext.proxy.httpproxy.port");
		port = portStr == null ? null : Integer.parseInt(portStr);
		isProxy = "true".equals(LogextProperties.getProperty("logext.proxy.httpproxy.enable", "true"))
				&& host != null && port != null;
	}
	
	public static void filterHttpProxy(Map<String, List<MethodParam>> map){
		if(!isProxy){
			map.remove("logext.proxys.initclass.httpproxy.default_httpproxy");
			map.remove("logext.proxys.list.httpproxy.default_httpproxy");
		}
	}
	
}
