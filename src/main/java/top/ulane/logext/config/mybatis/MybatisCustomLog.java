package top.ulane.logext.config.mybatis;

import org.apache.ibatis.logging.LogFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import top.ulane.logext.autoconfigure.ConditionalOnClass;
import top.ulane.logext.autoconfigure.ConditionalOnProperty;
import wang.ulane.log.CustomLogImpl;

//@Configuration
@ConditionalOnClass("org.mybatis.spring.SqlSessionFactoryBean")
@ConditionalOnProperty(value="logext.mybatis.customlog", havingValue="true", matchIfMissing=true)
public class MybatisCustomLog implements BeanPostProcessor{
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("before:"+beanName+":"+bean.getClass().getCanonicalName());
		if(bean instanceof SqlSessionFactoryBean){
//			System.out.println("before2:"+beanName);
			//直接static设置得话会比这里慢，多线程
			LogFactory.useCustomLogging(CustomLogImpl.class);
//			SqlSessionFactoryBean sqlSessionFactoryBean = (SqlSessionFactoryBean) bean;
//			try {
//				sqlSessionFactoryBean.getObject().getConfiguration().setLogImpl();
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("after:"+beanName);
		return bean;
	}
}

//class CusImportSelector implements ImportBeanDefinitionRegistrar{
////	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
////		return new String[]{ControllerAdvisorConfig.class.getCanonicalName(),ServiceAdvisorConfig.class.getCanonicalName()};
////	}
////	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
////		registry.registerBeanDefinition("serviceAdvisorConfig", BeanDefinitionBuilder.genericBeanDefinition(ServiceAdvisorConfig.class).getBeanDefinition());
////		registry.registerBeanDefinition("controllerAdvisorConfig", BeanDefinitionBuilder.genericBeanDefinition(ControllerAdvisorConfig.class).getBeanDefinition());
////	}
//}
