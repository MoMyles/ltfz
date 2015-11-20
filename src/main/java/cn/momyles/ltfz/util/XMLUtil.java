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
 * XML����������
 * @author MoMyles
 * @date 2015-11-20 09:07
 */
public class XMLUtil {
	/**
	 * ��XML��Ϣת��ΪMap
	 * @param request HttpServletRequest����
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws DocumentException
	, IOException {
		Map<String, String> map = new HashMap<String, String>();// xmlת��֮��Ĵ洢����
		SAXReader reader = new SAXReader();// ��ȡXML��Ϣ��
		InputStream is = request.getInputStream();// ����ļ���
		Document document = reader.read(is);// ��ȡ�ı�����
		Element root = document.getRootElement();// ��ȡ��Ԫ��
		List<Element> eles = root.elements();// ��ȡ���ڵ��µ�����Ԫ��
		for (Element e : eles) {// ��������Ԫ��
			map.put(e.getName(), e.getText());// ��Ԫ�صı�ǩ�������ݴ���map��
		}
		is.close();// �رն�ȡ��
		return map;
	}
}
