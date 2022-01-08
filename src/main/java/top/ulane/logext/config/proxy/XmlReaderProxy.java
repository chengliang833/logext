//package top.ulane.logext.config.proxy;
//
//import java.util.List;
//import java.util.Map;
//
//import top.ulane.logext.properties.LogextProperties;
//import wang.ulane.proxy.MethodParam;
//
//@Deprecated
//public class XmlReaderProxy {
//
//	public static final boolean isProxy = "true".equals(LogextProperties.getProperty("logext.proxy.xmlreader.enable", "true"));
//	
//	public static void filterHttpProxy(Map<String, List<MethodParam>> map){
//		if(!isProxy){
//			map.remove("logext.proxys.initclass.xmlreader.default_xmlreader");
//			map.remove("logext.proxys.list.xmlreader.default_xmlreader");
//		}
//	}
//	
//}
