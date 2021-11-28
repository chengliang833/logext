package top.ulane.logext.autoconfigure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Conditional(OnPropertyCondition.class)
public @interface ConditionalOnProperty {
	String value();
	String havingValue() default "";
	
	boolean matchIfMissing() default false;
	boolean matchIfExist() default false;
	
}
