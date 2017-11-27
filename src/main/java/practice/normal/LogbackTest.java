package practice.normal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

	public LogbackTest() {
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger=LoggerFactory.getLogger(LogbackTest.class); 
	
	public static void main(String[] args){
		logger.debug("启动程序！");
		System.out.println("打印12345");
		
	}
}
