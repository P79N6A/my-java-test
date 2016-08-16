package priv.zc.cglib;
import net.sf.cglib.proxy.Enhancer;


public class CgProxy {
	static MyInterceptor interceptor=new MyInterceptor();
	public static Object newInstance(Class clazz){
		Enhancer e=new Enhancer();
		e.setSuperclass(clazz);
		e.setCallback(interceptor);
		return e.create();
	}
	
	public static void main(String[] args) {
		Target target=(Target) newInstance(Target.class);
		target.say();
	}
}
