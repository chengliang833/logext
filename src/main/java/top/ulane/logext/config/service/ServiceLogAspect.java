package top.ulane.logext.config.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import wang.ulane.log.LogAspect;

//@Aspect
//@Order(100)
//@Component
public class ServiceLogAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return LogAspect.serviceAroundInvoke(invocation);
	}
	
//	@Around("execution(public * cn..*.ulane.read.*.*(..)) || execution(public * cn..*.ulane.write.*.*(..)) ")
//	@Around("execution(public * cn..*.ulane..*.*(..))")
//    public Object serviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		return serviceAroundInvoke(joinPoint);
//    }
	
}
