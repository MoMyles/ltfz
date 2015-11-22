package cn.momyles.ltfz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * XML操作工具类
 * @author MoMyles
 * @date 2015-11-20 09:07
 */
public class XMLUtil {
	/**
	 * 将XML文件存储到Map中
	 * @param request HttpServletRequest对象
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws DocumentException
	, IOException {
		Map<String, String> map = new HashMap<String, String>();// xml存储对象
		SAXReader reader = new SAXReader();// XML读取对象
		InputStream is = request.getInputStream();// 获取请求流
		Document document = reader.read(is);// 读取
		Element root = document.getRootElement();// 获得根节点
		List<Element> eles = root.elements();// 获得根节点下的所有内容
		for (Element e : eles) {// 迭代所有元素
			map.put(e.getName(), e.getText());// 将元素的名称及内容存入Map
		}
		is.close();// 关闭流
		return map;
	}
}
