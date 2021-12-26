package top.ulane.logext.config.proxy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;
import wang.ulane.proxy.MethodParam;
import wang.ulane.proxy.ProxyClass;

/**
 * http代理配置
 * 必须继承BeanDefinitionRegistryPostProcessor，保证当前class在BeanDefinition之前加载，如先于其他包中的HttpPost加载
 */
@ConditionalOnProperty(value="logext.proxy.enable", havingValue="true")
public class ProxyConfig implements BeanDefinitionRegistryPostProcessor{
	
	static {
//		System.out.println(0);
		ProxyClass.initClass("logext.properties", "logext.proxys.initclass");
		Map<String, List<MethodParam>> map = ProxyClass.getMethodList("logext.properties", "logext.proxys.list");
//		System.out.println(map);
//		System.out.println(ProxyClass.getRelateClassPaths());
		for(String className:map.keySet()){
			ProxyClass.proxyMethod(className, map.get(className).toArray(new MethodParam[]{}));
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		System.out.println(2);
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		System.out.println(1);
	}
	
}
