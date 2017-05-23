package priv.zc.cglib;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyInterceptor implements MethodInterceptor {

	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println(" interceptor worked");
		return arg3.invokeSuper(arg0, arg2);
	}
}
