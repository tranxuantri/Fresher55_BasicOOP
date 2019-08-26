package assigment.log;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jTest {
	static Logger logger = Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		logger.info("abc");
		logger.error("day la loi");
		
	}
	public String toString() {
		logger.debug("Person toString begin");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//if (!true) return "Is not valide object";
		logger.info("Another message with the \"begin\" word");
		logger.debug("Person toString end.");
		return "" + df.format("11/2/1997");
		
	}
}
