package priv.zc.servlet;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zongchao on 16/11/9.
 */
public class VelocityTestServlet extends VelocityViewServlet{
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        ctx.put("name","张三");
        return getTemplate("test.vm");
    }
}
