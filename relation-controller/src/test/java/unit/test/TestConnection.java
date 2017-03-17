package unit.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestConnection {

	private static ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-beans.xml");


	@Test
	@Ignore
	public void test01() throws Exception{
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		connection.close();
	}
}
