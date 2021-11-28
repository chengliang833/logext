package top.ulane.logext;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;

import top.ulane.logext.properties.LogextProperties;
import wang.ulane.file.TraverseFileFromSign;

public class UlaneAutoConfigurationImportSelector implements ImportSelector{
	protected static Logger log = LoggerFactory.getLogger(UlaneAutoConfigurationImportSelector.class);

	private String enableAutoConfiguration;
	
	static {
		Properties properties;
		try {
			properties = PropertiesLoaderUtils.loadAllProperties("logext.properties");
			List<String> files = TraverseFileFromSign.getFiles("/properties");
			for(String path:files){
				if(path.endsWith(".properties")){
					properties.putAll(PropertiesLoaderUtils.loadAllProperties(path));
				}
			}
			LogextProperties.initProperties(properties);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public UlaneAutoConfigurationImportSelector() throws IOException {
		super();
        this.enableAutoConfiguration = LogextProperties.getProperty("top.ulane.auto.configure.EnableAutoConfiguration");
	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{this.enableAutoConfiguration};
	}

}
