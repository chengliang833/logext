package top.ulane.logext.autoconfigure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;

public class OnClassCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> map = metadata.getAllAnnotationAttributes(ConditionalOnClass.class.getName());
		List<String> clznames = new ArrayList<String>();
		for (Object item : map.get("value")) {
			Collections.addAll(clznames, (String[]) item);
		}
		if(clznames.size() == 0){
			return true;
		}
		return clznames.stream().allMatch(str -> isPresent(str, OnClassCondition.class.getClassLoader()));
	}
	
	public static boolean isPresent(String className, ClassLoader classLoader) {
		if (classLoader == null) {
			classLoader = ClassUtils.getDefaultClassLoader();
		}
		try {
			forName(className, classLoader);
			return true;
		}
		catch (Throwable ex) {
			return false;
		}
	}

	private static Class<?> forName(String className, ClassLoader classLoader)
			throws ClassNotFoundException {
		if (classLoader != null) {
			return classLoader.loadClass(className);
		}
		return Class.forName(className);
	}
	
}
