//package top.ulane.logext.autoconfigure;
//
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//import org.springframework.util.MultiValueMap;
//
//import top.ulane.logext.properties.LogextProperties;
//
//public class OnMissingBeanCondition implements Condition{
//
//	@Override
//	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//		MultiValueMap<String, Object> map = metadata.getAllAnnotationAttributes(ConditionalOnProperty.class.getName());
//		System.out.println("OnMissingBeanCondition:"+map);
//		return false;
//	}
//	
//}
