package priv.zc.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.zc.cache.CacheService;

@Service("emailService")
public class EmailService {
	public static final String DEFAULT_CHARSET="UTF-8";
	
	public static final String EMAIL_HOST = "email.host";
	public static final String EMAIL_USERNAME = "email.username";
	public static final String EMAIL_PASSWORD = "email.password";
	public static final String EMAIL_FROM = "email.from";
	@Autowired
	private CacheService cacheService;
	
	public String sendEmail(String to, String subject, String content) throws EmailException {
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setCharset(DEFAULT_CHARSET);
		String host = (String) cacheService.get(EMAIL_HOST);
		String username = (String) cacheService.get(EMAIL_USERNAME);
		String password = (String) cacheService.get(EMAIL_PASSWORD);
		String from = (String) cacheService.get(EMAIL_FROM);
		simpleEmail.setHostName(host);
		simpleEmail.setAuthentication(username, password);
		simpleEmail.setFrom(from);
		simpleEmail.addTo(to);
		simpleEmail.setSubject(DEFAULT_CHARSET);
		String emailId = simpleEmail.send();
		return emailId;
	}
}
