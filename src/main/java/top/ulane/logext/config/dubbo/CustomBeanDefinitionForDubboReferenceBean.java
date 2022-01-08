package top.ulane.logext.config.dubbo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.spring.ReferenceBean;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;

@ConditionalOnProperty(value="logext.dubbo.appendcustomer", havingValue="true")
public class CustomBeanDefinitionForDubboReferenceBean implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Bean
	public ReferenceBean<InvokeDirectlyInterface> referenceBeanIdi() throws Exception{
		ReferenceBean<InvokeDirectlyInterface> rb = new ReferenceBean<>();
		rb.setInterface("top.ulane.logext.config.dubbo.InvokeDirectlyInterface");
		rb.setId("invokeDirectlyInterface");
		rb.setCheck(false);
		rb.setLoadbalance("roundrobin");
		rb.setRetries(0);
		rb.setApplicationContext(applicationContext);
		rb.afterPropertiesSet();
		return rb;
	}
	
//	@Override
//	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		BeanDefinitionBuilder b = BeanDefinitionBuilder.genericBeanDefinition(ReferenceBean.class)
//				.addPropertyValue("interface", "top.ulane.logext.config.dubbo.InvokeDirectlyInterface")
//				.addPropertyValue("id", "invokeDirectlyInterface")
//				.addPropertyValue("check", "false")
//				.addPropertyValue("loadbalance","roundrobin")
//				.addPropertyValue("retries","0");
//		registry.registerBeanDefinition("invokeDirectlyInterface", b.getBeanDefinition());
////		System.out.println(registry.getBeanDefinition("invokeDirectlyInterface"));
//	}
//	
//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//	
//	}
	
}
