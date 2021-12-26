package top.ulane.logext.config.proxy;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

import top.ulane.logext.properties.LogextProperties;

public class HttpProxyAop {
	
	public static final String host = LogextProperties.getProperty("logext.proxy.host");
	public static final Integer port;
	public static final boolean isProxy;
	
	static {
		String portStr = LogextProperties.getProperty("logext.proxy.port");
		port = portStr == null ? null : Integer.parseInt(portStr);
		isProxy = host != null && port != null;
	}
	
	public static void httpPostBefore(){
//		System.out.println("httpPostBefore");
	}
	
	public static void httpPostAfter(Object httpPostObj){
//		System.out.println(host+":"+port);
//		System.out.println("after:"+httpPostObj);
		if(!isProxy){
			return;
		}
		HttpPost post = (HttpPost) httpPostObj;
		RequestConfig requestConfig = post.getConfig();
		HttpHost httpHost = new HttpHost(host, port);
		if(requestConfig == null){
			requestConfig = RequestConfig.custom().setProxy(httpHost).build();
		}else{
			requestConfig = RequestConfig.copy(requestConfig).setProxy(httpHost).build();
		}
//		System.out.println(requestConfig);
		post.setConfig(requestConfig);
	}
	
}
