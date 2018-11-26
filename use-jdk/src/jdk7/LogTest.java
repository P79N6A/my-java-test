package jdk7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("global");
		log.setLevel(Level.FINER);
		System.out.println(log.getLevel());
		log.finest("finest");
		log.finer("finer");
		log.fine("fine");
		log.info("info");
		log.warning("warning");
		log.severe("servere");
	}
}
