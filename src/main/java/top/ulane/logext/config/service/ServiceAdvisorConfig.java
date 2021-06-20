package top.ulane.logext.config.service;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import top.ulane.logext.config.LogAspectExt;

@Configuration
public class ServiceAdvisorConfig extends LogAspectExt{
	
	@Value("${logext.service.around:execution(public * cn..*.ulane..*.*(..))}")
	private String pointcut;

	@Bean
	public AspectJExpressionPointcutAdvisor configurabledvisor() {
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(pointcut);
		advisor.setOrder(100);
		//new 不能执行@value，不再继承LogAspect，改为当前类直接继承LogAspect
		advisor.setAdvice(new ServiceLogAspect());
		return advisor;
	}
	
}
