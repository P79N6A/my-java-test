package priv.zc.user.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("aopAdvisor")
public class AopAdvisor implements MethodInterceptor{
	private Logger log=Logger.getLogger(this.getClass());
	
	public Object invoke(MethodInvocation arg0) throws Throwable {
		Method method=arg0.getMethod();
		Object[] args=arg0.getArguments();
		Object target=arg0.getThis();
		log.info("method="+method+" args="+args);
		return method.invoke(target, args);
	}

}
