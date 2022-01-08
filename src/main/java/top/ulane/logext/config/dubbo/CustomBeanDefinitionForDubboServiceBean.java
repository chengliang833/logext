package top.ulane.logext.config.dubbo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.spring.ServiceBean;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;

@ConditionalOnProperty(value="logext.dubbo.appendprovider", havingValue="true")
public class CustomBeanDefinitionForDubboServiceBean implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Bean
	//自定义servicebean,如果在postProcessBeanFactory中关联太早，会导致invokeDirectlyService没有被aop
	public ServiceBean<InvokeDirectlyInterface> serviceBeanIdi() throws Exception{
		ServiceBean<InvokeDirectlyInterface> sb = new ServiceBean<>();
		sb.setInterface("top.ulane.logext.config.dubbo.InvokeDirectlyInterface");
		sb.setRef((InvokeDirectlyInterface) applicationContext.getBean("invokeDirectlyService"));
		sb.setTimeout(300000);
		sb.setRetries(0);
		sb.setLoadbalance("roundrobin");
		sb.setApplicationContext(applicationContext);
		sb.afterPropertiesSet();
		return sb;
	}

//	@Bean(name="annotation")
//	@ConditionalOnProperty(value="logext.dubbo.appendprovider.scanpackage", matchIfExist=true)
//	public AnnotationBeanCustom annotationBeanCustom(){
//		AnnotationBeanCustom annotationBeanCustom = new AnnotationBeanCustom();
//		annotationBeanCustom.setApplicationContext(applicationContext);
//		annotationBeanCustom.setPackage(LogextProperties.getProperty("logext.dubbo.appendprovider.scanpackage"));
//		annotationBeanCustom.setId("annotation");
//		return annotationBeanCustom;
//	}
	
//	@Override
//	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		//用BeanDefinition无法export到zk
//		String scanpackage = LogextProperties.getProperty("logext.dubbo.appendprovider.scanpackage");
//		if(!StringUtils.isNull(scanpackage)){
//			BeanDefinitionBuilder b = BeanDefinitionBuilder.genericBeanDefinition(AnnotationBeanCustom.class)
//					.addPropertyValue("package", scanpackage);
//			registry.registerBeanDefinition("annotation", b.getBeanDefinition());
//		}
//		
//		//直接加ServiceBean会导致aop无法生效
////		BeanDefinitionBuilder b = BeanDefinitionBuilder.genericBeanDefinition(ServiceBean.class)
////				.addPropertyValue("interface", "top.ulane.logext.config.dubbo.InvokeDirectlyInterface")
//////				.addPropertyValue("ref", "invokeDirectlyService")
////				.addPropertyValue("timeout", "300000")
////				.addPropertyValue("retries","0")
////				.addPropertyValue("loadbalance","roundrobin");
//////				.setLazyInit(true);
////		registry.registerBeanDefinition("top.ulane.logext.config.dubbo.InvokeDirectlyInterface", b.getBeanDefinition());
////		System.out.println(registry.getBeanDefinition("top.ulane.logext.config.dubbo.InvokeDirectlyInterface"));
//	}
//	
//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
////		beanFactory.getBeanDefinition("top.ulane.logext.config.dubbo.InvokeDirectlyInterface")
////				.getPropertyValues().addPropertyValue("ref", beanFactory.getBean("invokeDirectlyService"));
//	}
	
}
