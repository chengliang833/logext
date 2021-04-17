package top.ulane.logext.config.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import top.ulane.logext.config.LogAspect;

@Aspect
@Order(100)
@Component
public class ControllerLogAspect extends LogAspect {
	
	@Around("execution(public * com..*.impl.*.*(..))")
	public Object controllerArount(ProceedingJoinPoint joinPoint) throws Throwable{
        return controllerAroundInvoke(joinPoint);
	}
	
}
