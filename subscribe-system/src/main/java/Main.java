import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class Main {
	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String DEFAULT_CONFIGURATION_FILE = "config.properties";

	// properties
	public static final String DATAFILE = "datafile";
	public static final String URL = "url";
	public static final String CSS_SELECTOR = "cssSelector";

	public static final String EMAIL_HOST = "email.host";
	public static final String EMAIL_USERNAME = "email.username";
	public static final String EMAIL_PASSWORD = "email.password";
	public static final String EMAIL_FROM = "email.from";
	public static final String EMAIL_TO = "email.to";
	public static final String EMAIL_SUBJECT = "email.subject";
	public static final String EMAIL_CONTENT = "email.content";

	public static void main(String[] args) throws EmailException, ParserException, IOException {
		// 载入配置
		Properties prop = new Properties();
		InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(DEFAULT_CONFIGURATION_FILE);
		prop.load(inputStream);

		// 获取配置
		String url = prop.getProperty(URL);
		String cssSelector = prop.getProperty(CSS_SELECTOR);
		String filename = prop.getProperty(DATAFILE);
		String host = prop.getProperty(EMAIL_HOST);
		String username = prop.getProperty(EMAIL_USERNAME);
		String password = prop.getProperty(EMAIL_PASSWORD);
		String from = prop.getProperty(EMAIL_FROM);
		String to = prop.getProperty(EMAIL_TO);
		String subject = prop.getProperty(EMAIL_SUBJECT);
		String content = prop.getProperty(EMAIL_CONTENT);

		// 获取更新字段
		String title = getKeyString(url, cssSelector);
		// 比较字段
		String oldTitle = null;
		try {
			oldTitle = FileUtils.readFileToString(new File(filename), DEFAULT_CHARSET);
			if (StringUtils.equals(title, oldTitle)) {
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			// 更新
			FileUtils.write(new File(filename), title, DEFAULT_CHARSET);
		}
		// 邮件提醒
		{
			SimpleEmail simpleEmail = new SimpleEmail();
			simpleEmail.setSSLOnConnect(true);
			simpleEmail.setCharset(DEFAULT_CHARSET);
			simpleEmail.setHostName(host);
			simpleEmail.setAuthentication(username, password);
			simpleEmail.setFrom(from);
			simpleEmail.addTo(to);
			String replacedSubject = subject.replace("{1}", title);
			simpleEmail.setSubject(replacedSubject);
			simpleEmail.setMsg(content);
			String emailId = simpleEmail.send();
			System.out.println(emailId);
		}
	}

	public static String getKeyString(String url, String cssSelector) throws ParserException {
		Parser parser = new Parser(url);
		CssSelectorNodeFilter nodeClassFilter = new CssSelectorNodeFilter(cssSelector);
		NodeList nodeList = parser.parse(nodeClassFilter);
		String title = nodeList.elementAt(0).toPlainTextString().replace("&nbsp;", "").trim();
		return title;
	}
}
