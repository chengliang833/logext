package top.ulane.logext.config.controller;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import wang.ulane.log.LogAspect;

//@Aspect
//@Order(100)
//@Component
public class ControllerLogAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return LogAspect.controllerAroundInvoke(invocation);
	}
	
//	@Around("execution(public * cn..*.ulane.*.*(..))")
//	public Object controllerArount(ProceedingJoinPoint joinPoint) throws Throwable{
//        return controllerAroundInvoke(joinPoint);
//	}
	
}
