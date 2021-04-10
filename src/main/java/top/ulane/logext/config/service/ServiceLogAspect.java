package top.ulane.logext.config.service;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import top.ulane.logext.config.LogAspect;

@Aspect
@Order(100)
@Component
public class ServiceLogAspect extends LogAspect{
	
//	@Around("execution(public * com..*.business.read.*.*(..)) || execution(public * com..*.business.write.*.*(..)) ")
	@Around("execution(public * com..*.business..*.*(..))")
    public Object serviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	    Method method = signature.getMethod();
	    Class<?> targetClass = method.getDeclaringClass();
	    String target = targetClass.getName() + ":" + method.getName();
		Object[] args = joinPoint.getArgs();
		
		long start = System.currentTimeMillis();
		
		printLogBeforeProceed(target, JSONObject.toJSONString(args));
		
		Object result = joinPoint.proceed();
		long timeConsuming = System.currentTimeMillis() - start;
		printObjectLogAfterProceed(target, timeConsuming, result);
		
		return result;
    }
	
}
