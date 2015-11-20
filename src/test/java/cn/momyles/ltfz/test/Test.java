package cn.momyles.ltfz.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	public static void main(String[] args) {
//		File file = new File("jdbcConfig.properties");
//		System.out.println(file);
		//Test log4j
		Logger logger = LoggerFactory.getLogger(Test.class);
		logger.error("test.....log");
	}
}
