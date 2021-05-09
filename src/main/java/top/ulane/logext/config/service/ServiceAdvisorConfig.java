package top.ulane.logext.config.service;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAdvisorConfig {
	
	@Value("${logext.service.around:execution(public * cn..*.ulane..*.*(..))}")
	private String pointcut;

	@Bean
	public AspectJExpressionPointcutAdvisor configurabledvisor() {
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(pointcut);
		advisor.setOrder(100);
		advisor.setAdvice(new ServiceLogAspect());
		return advisor;
	}
	
}
