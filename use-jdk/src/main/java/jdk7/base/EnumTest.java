package jdk7.base;

/**
 * 17/2/28.
 */
public class EnumTest {
    public enum Type{
        NORAML,FROZON,DELETE
    }

    public static void main(String[] args) {
        System.out.println(Type.DELETE.name());
        System.out.println(Type.DELETE.ordinal());
        new EnumTest().test(Type.NORAML);
    }

    private void test(Type type){
        System.out.println(type == Type.NORAML);
    }
}
