package top.ulane.logext.config.proxy;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

public class HttpProxyAop extends HttpProxy {
	
	public static void httpPostBefore(){
//		System.out.println("httpPostBefore");
	}
	
	public static void httpPostAfter(Object httpPostObj){
//		System.out.println(host+":"+port);
//		System.out.println("after:"+httpPostObj);
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
