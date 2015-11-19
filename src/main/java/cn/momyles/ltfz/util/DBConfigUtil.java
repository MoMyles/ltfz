package cn.momyles.ltfz.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DB配置文件读取
 * @author MoMyles
 * @date 2015-11-17 21:55 PM
 */
public class DBConfigUtil {
	
	private static final Logger log = LoggerFactory.getLogger(DBConfigUtil.class);
	
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(DBConfigUtil.class.getClassLoader().getResourceAsStream("jdbcConfig.properties"));
		} catch (IOException e) {
			log.error("读取数据库配置文件出错");
		}
	}
	
	public static Properties getPropertiesFile() {
		return prop;
	}
}
