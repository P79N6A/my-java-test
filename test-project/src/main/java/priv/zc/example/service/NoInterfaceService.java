package priv.zc.example.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NoInterfaceService {
	private static Logger log=Logger.getLogger(NoInterfaceService.class);
	public String test(){
		log.info("nointerfaceService invoked!!");
		return new Date().toString();
	}
}
