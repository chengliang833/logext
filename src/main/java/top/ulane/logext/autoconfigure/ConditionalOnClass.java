package top.ulane.logext.autoconfigure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Conditional(OnClassCondition.class)
public @interface ConditionalOnClass {
	
	String[] value() default {};	
	
}
