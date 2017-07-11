package priv.zc.user.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 17/4/5.
 */

@Component
public class Scan1Bean implements InitializingBean,DisposableBean {
    private Logger logger = Logger.getLogger(Scan1Bean.class);
    public void destroy() throws Exception {
         logger.debug("DisposableBean interface invoked!");
    }

    public void afterPropertiesSet() throws Exception {
        logger.debug("InitializingBean interface invoked!");

    }
}
