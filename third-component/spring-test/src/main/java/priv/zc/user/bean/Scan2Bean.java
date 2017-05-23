package priv.zc.user.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 17/4/5.
 */
@Component
public class Scan2Bean {
    private Logger logger = Logger.getLogger(Scan2Bean.class);

    @PostConstruct
    public void so(){
        logger.debug("@PostConstruct invoked!");
    }

    @PreDestroy
    public void ef(){
        logger.debug("@PreDestroy invoked!");
    }
}
