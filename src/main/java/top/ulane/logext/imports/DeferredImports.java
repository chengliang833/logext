package top.ulane.logext.imports;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import top.ulane.logext.config.aop.AopConfig;

public class DeferredImports implements DeferredImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{AopConfig.class.getCanonicalName()};
	}

}
