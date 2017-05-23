package priv.zc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

	private Object target;
	private Interceptor interceptor;

	public TargetProxy(Object target,Interceptor interceptor) {
		this.target = target;
		this.interceptor=interceptor;
	}

	public static Object bind(Object target,Interceptor interceptor) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new TargetProxy(target,interceptor));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("proxy is working..");
		interceptor.interceptor();
		return method.invoke(target, args);
	}

}
