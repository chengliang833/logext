package top.ulane.logext.config.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import top.ulane.logext.autoconfigure.ConditionalOnProperty;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@ConditionalOnProperty(value="logext.autoproxy.enable", havingValue="true", matchIfMissing=true)
public class AopConfig {
	
}
