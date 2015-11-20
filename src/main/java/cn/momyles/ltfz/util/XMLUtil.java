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
	 * 将XML信息转换为Map
	 * @param request HttpServletRequest请求
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws DocumentException
	, IOException {
		Map<String, String> map = new HashMap<String, String>();// xml转换之后的存储对象
		SAXReader reader = new SAXReader();// 读取XML信息类
		InputStream is = request.getInputStream();// 获得文件流
		Document document = reader.read(is);// 获取文本对象
		Element root = document.getRootElement();// 获取根元素
		List<Element> eles = root.elements();// 获取根节点下的所有元素
		for (Element e : eles) {// 迭代所有元素
			map.put(e.getName(), e.getText());// 将元素的标签名及内容存入map中
		}
		is.close();// 关闭读取流
		return map;
	}
}
