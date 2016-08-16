package priv.zc.proxy;

public class Client {
	public static void main(String[] args) {
		Target target=new TargetImpl();
		target.execute();
		
		target=(Target) TargetProxy.bind(target,new Interceptor() {
			
			@Override
			public void interceptor() {
				System.out.println("Interceptor running..");
				
			}
		});
		target.execute();
	}
}
