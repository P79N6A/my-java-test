package log4j;

import java.util.Properties;

import org.apache.log4j.Logger;

public class RemoteLog {

	public static void main(String[] args) throws InterruptedException {

		Properties props = System.getProperties();
		props.setProperty("log4j.configuration", "test/log4j.remote.properties");
		Logger log = Logger.getLogger(RemoteLog.class);
		for (int i = 0; i < 10; i++) {
			log.debug("test 李恩来 .avi " + i);
			Thread.sleep(500);
		}
	}
}
