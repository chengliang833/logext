package top.ulane.logext.config.controller;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import top.ulane.logext.config.LogAspectExt;

@Configuration
public class ControllerAdvisorConfig extends LogAspectExt {
	
	@Value("${logext.controller.around:execution(public * cn..*.ulane.*.*(..))}")
	private String pointcut;

	@Bean
	public AspectJExpressionPointcutAdvisor configurabledvisor() {
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(pointcut);
		advisor.setOrder(100);
		advisor.setAdvice(new ControllerLogAspect());
		return advisor;
	}
	
}
