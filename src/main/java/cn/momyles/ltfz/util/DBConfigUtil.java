package cn.momyles.ltfz.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * DB�����ļ���ȡ
 * @author MoMyles
 * @date 2015-11-17 21:55 PM
 */
public class DBConfigUtil {
	
	private static final Logger log = Logger.getLogger(DBConfigUtil.class);
	
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(DBConfigUtil.class.getClassLoader().getResourceAsStream("jdbcConfig.properties"));
		} catch (IOException e) {
			log.error("��ȡ���ݿ������ļ�����");
		}
	}
	
	public static Properties getPropertiesFile() {
		return prop;
	}
}
