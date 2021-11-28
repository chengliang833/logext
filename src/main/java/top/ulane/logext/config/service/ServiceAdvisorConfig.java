package top.ulane.logext.config.service;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;

//@Configuration
@ConditionalOnProperty(value="logext.service.around", matchIfExist=true)
public class ServiceAdvisorConfig {
	
//	@Value("${logext.service.around:execution(public * cn..*.ulane..*.*(..))}")
	@Value("${logext.service.around}")
	private String pointcut;
	
	@Bean(name="servicePointcutAdvisor")
	public AspectJExpressionPointcutAdvisor configurabledvisor() {
//		System.out.println("pointcut:"+pointcut);
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(pointcut);
		advisor.setOrder(100);
		//new 不能执行@value，不再继承LogAspect，改为当前类直接继承LogAspect
		advisor.setAdvice(new ServiceLogAspect());
		return advisor;
	}
	
}
