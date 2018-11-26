package priv.zc.utils.apache.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.PrintWriter;
import java.io.Writer;


/**
 * 16/11/8.
 */
public class VelocityTest {
    public static void main(String[] args) {
        Velocity velocity = new Velocity();
        System.out.println(System.getProperties().getProperty("user.dir"));
//        String path = "/test-project/src/test/java/apache/velocity/";
//        velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,path);
//        velocity.setProperty(Velocity.INPUT_ENCODING,"UTF-8");
//        velocity.setProperty(Velocity.OUTPUT_ENCODING,"UTF-8");

        try {
            velocity.init();
            System.out.println(velocity);
            Template template = velocity.getTemplate("test-project/src/test/java/apache/velocity/helloworld.vm");
            VelocityContext root = new VelocityContext();
            root.put("name","张三");
            String outpath = "test-project/src/test/java/apache/velocity/hello.html";
//            Writer writer = new PrintWriter(new FileOutputStream(new File(outpath)));
            Writer writer = new PrintWriter(System.out);
            template.merge(root, writer);
            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
