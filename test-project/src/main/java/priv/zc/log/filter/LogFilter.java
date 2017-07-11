package priv.zc.log.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 16/11/12.
 */
public class LogFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long timeCost = System.currentTimeMillis() - startTime;
        log.info("uri:{} time:{} param:{}", uri, timeCost,getParameters(req));
    }

    public static Map<String,String> getParameters(HttpServletRequest request){
        Map<String,String> map = new HashMap<String,String>();
        for(Map.Entry<String,String[]> entry:request.getParameterMap().entrySet()){
           map.put(entry.getKey(),entry.getValue()[0]);
        }
        return map;
    }

    @Override
    public void destroy() {

    }
}
