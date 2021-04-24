package top.ulane.logext.config.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import top.ulane.logext.config.LogAspectExt;

@Aspect
@Order(100)
@Component
public class ServiceLogAspect extends LogAspectExt{
	
//	@Around("execution(public * com..*.business.read.*.*(..)) || execution(public * com..*.business.write.*.*(..)) ")
	@Around("execution(public * com..*.business..*.*(..))")
    public Object serviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return serviceAroundInvoke(joinPoint);
    }
	
}
