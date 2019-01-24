package a1;

public class A extends B {

	public int a = 100;

	public A() {
		super();
		System.out.println(a);
		a = 200;
	}

	static {
		System.out.println("static A");
	}

	public static void main(String[] args) {
		new A();
	}

}

class B {
	public B() {
		System.out.println(((A) this).a);
	}
}
