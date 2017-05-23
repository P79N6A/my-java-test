package priv.zc.proxy;

public class TargetImpl implements Target{

	@Override
	public void execute() {
		System.out.println(this.getClass()+" is runing..");
	}

}
