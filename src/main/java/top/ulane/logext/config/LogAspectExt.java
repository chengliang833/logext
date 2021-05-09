package top.ulane.logext.config;

import java.util.List;
import java.util.Map;

import wang.ulane.log.LogAspect;
import wang.ulane.proxy.MethodParam;
import wang.ulane.proxy.ProxyClass;
import wang.ulane.proxy.ProxyClassLog;

public class LogAspectExt extends LogAspect{

	static {
		ProxyClass.initClass("properties/app.properties", "logext.proxys.initclass");
		Map<String, List<MethodParam>> map = ProxyClass.getMethodList("properties/app.properties", "logext.proxys.list");
		ProxyClassLog.proxyMethodLog(map);
	}
	
}
