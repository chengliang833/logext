package top.ulane.logext.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Intercepts( {
    @Signature( method = "query", type = Executor.class, args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class} ),
    @Signature( method = "update", type = Executor.class,  args = {MappedStatement.class, Object.class}),
//    @Signature( method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class} )
	})
public class IbatisInterceptor implements Interceptor{
	private static final Logger log = LoggerFactory.getLogger(IbatisInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		String sql = "";
		Object[] paramArr = null;
    	String mName = invocation.getMethod().getName();
        log.info("mName:"+mName);
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		if ("update".equals(mName)) {
			sql = boundSql.getSql();
		} else if ("query".equals(mName)) {
			sql = boundSql.getSql();
//		} else if ("prepare".equals(mName)) {
		}
		log.info("sql:"+sql.replaceAll("[\r\n]*",""));

		Object obj = boundSql.getParameterObject();
		if(obj != null){
			log.info("param:"+obj.toString());
		}

		Object result = invocation.proceed();

		log.info("finish...");
		return result;
	}
	
	@Override
	public Object plugin(Object target) {
		//全部Excutor走代理
//		if (target instanceof CachingExecutor) {
//            Executor a = (Executor) target;
            return Plugin.wrap(target, this);
//        } else {
//            return target;
//        }
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
