package practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import practice.spring.UserTest;


public class SpringTest {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		System.out.print("");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserTest user=context.getBean(UserTest.class);
		System.out.println(user);
		//UserTest user=(UserTest)context.getBean("userTest");
		
	}

}
