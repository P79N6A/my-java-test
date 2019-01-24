package classloader;

import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------BootstrapClassloader-------");
        bootstrapClassloader();
        System.out.println("-------ExtClassloader-------");
        extClassLoader();
        System.out.println("-------AppClassloader-------");
        appClassLoader();
        System.out.println("-------ClassLoader Hierarchy-------");
        hierarchy();

    }

    /**
     * BootstrapClassloader 引导类加载器,主要用来加载Java核心类
     */
    public static void bootstrapClassloader() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }

    /**
     * ExtClassloader 扩展类加载器,主要负责加载Java的扩展类库。
     * 默认加载JAVA_HOME/jre/lib/ext/目下的所有jar包或者由java.ext.dirs系统属性指定的jar包
     */
    public static void extClassLoader() {
        //        System.out.println(System.getProperty("java.ext.dirs"));
        for (String s : System.getProperty("java.ext.dirs").split(File.pathSeparator)) {
            System.out.println(s);
        }
    }

    /**
     * AppClassLoader 系统类加载器,又称应用加载器,常说的SystemClassloader就是AppClassloader。
     * 负责在JVM启动时,加载来自在命令java中的-classpath或者java.class.path系统属性或者 CLASSPATH操作系统属性所指定的JAR类包和类路径
     */
    public static void appClassLoader() {
        //        System.out.println(System.getProperty("java.class.path"));
        for (String s : System.getProperty("java.class.path").split(File.pathSeparator)) {
            System.out.println(s);
        }
    }

    /**
     * 加载器关系,UserClassloader->AppClassloader->ExtClassloader->Bootstrap
     */
    public static void hierarchy(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader fatherClassLoader = systemClassLoader.getParent();
        System.out.println(fatherClassLoader);
        ClassLoader grandpaClassLoader = fatherClassLoader.getParent();
        System.out.println(grandpaClassLoader);
    }
}
