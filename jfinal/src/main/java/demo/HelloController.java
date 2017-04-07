package demo;
import com.jfinal.core.Controller;
public class HelloController extends Controller {
    public void index() {
        renderText("Hello JFinal world.");
    }

    public void jsp(){
        renderJsp("index.jsp");

    }

    public void vm(){
        setAttr("name","张三");
        renderVelocity("index.vm");
    }
}