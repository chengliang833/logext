package top.ulane.logext.config.controller;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;

//@Configuration
@ConditionalOnProperty(value="logext.controller.around", matchIfExist=true)
public class ControllerAdvisorConfig {
	
//	@Value("${logext.controller.around:execution(public * cn..*.ulane.*.*(..))}")
	@Value("${logext.controller.around}")
	private String pointcut;

	//通过@import导入时，必须配置name，否则会和service覆盖
	@Bean(name="controllerPointcutAdvisor")
	public AspectJExpressionPointcutAdvisor configurabledvisor() {
//		System.out.println("pointcut:"+pointcut);
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(pointcut);
		advisor.setOrder(100);
		advisor.setAdvice(new ControllerLogAspect());
		return advisor;
	}
	
}
