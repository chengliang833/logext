package top.ulane.logext.autoconfigure;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import top.ulane.logext.properties.LogextProperties;

public class OnPropertyCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> map = metadata.getAllAnnotationAttributes(ConditionalOnProperty.class.getName());
		String key = (String) map.getFirst("value");
		String value = (String) map.getFirst("havingValue");
		boolean matchIfExist = (boolean) map.getFirst("matchIfExist");
		boolean matchIfMissing = (boolean) map.getFirst("matchIfMissing");
		//先于properties加载，使用自定义文件加载
//		String envValue = context.getEnvironment().getProperty(key);
		String envValue = LogextProperties.getProperty(key);
//		if(envValue == null){
//			if(matchIfMissing){
//				return true;
//			}else{
//				//用户没配置，但是有条件"miss则不匹配"
//				return false;
//			}
//		}else if(matchIfExist){
//			//有条件"存在则匹配"
//			return true;
//		}else{
//			return envValue.equals(value);
//		}
		return (envValue == null && matchIfMissing) 
				|| (envValue != null && matchIfExist) 
				|| value.equals(envValue);
	}
	
}
