package top.ulane.logext.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;
import top.ulane.logext.config.LogAspectExt;
import top.ulane.logext.config.aop.AopConfig;
import top.ulane.logext.config.controller.ControllerAdvisorConfig;
import top.ulane.logext.config.dubbo.CustomBeanDefinitionForDubboReferenceBean;
import top.ulane.logext.config.dubbo.CustomBeanDefinitionForDubboServiceBean;
import top.ulane.logext.config.dubbo.DubboLogLevel;
import top.ulane.logext.config.mybatis.MybatisCustomLog;
import top.ulane.logext.config.proxy.ProxyConfig;
import top.ulane.logext.config.service.ServiceAdvisorConfig;

//@Configuration
@Import(CustomImports.class)
@ConditionalOnProperty(value="logext.enable", havingValue="true", matchIfMissing=true)
public class LogextAutoConfitguration{
	
	@Bean
	public LogAspectExt logAspectExt(){
		return new LogAspectExt();
	}

}

class CustomImports implements ImportSelector{
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{
			DubboLogLevel.class.getCanonicalName(),
			AopConfig.class.getCanonicalName(),
			ControllerAdvisorConfig.class.getCanonicalName(),
			ServiceAdvisorConfig.class.getCanonicalName(),
			MybatisCustomLog.class.getCanonicalName(),
			ProxyConfig.class.getCanonicalName(),
			CustomBeanDefinitionForDubboServiceBean.class.getCanonicalName(),
			CustomBeanDefinitionForDubboReferenceBean.class.getCanonicalName(),
			DeferredImports.class.getCanonicalName()
		};
	}
}


