package top.ulane.logext.config;

import java.util.List;
import java.util.Map;

import top.ulane.logext.config.proxy.MethodParam;
import top.ulane.logext.config.proxy.ProxyClass;
import top.ulane.logext.config.proxy.ProxyClassLog;

public class LogAspectExt extends LogAspect{

	static {
		ProxyClass.initClass("properties/app.properties", "log.proxys.initclass");
		Map<String, List<MethodParam>> map = ProxyClass.getMethodList("properties/app.properties", "log.proxys.list");
		ProxyClassLog.proxyMethodLog(map);
	}
	
}
