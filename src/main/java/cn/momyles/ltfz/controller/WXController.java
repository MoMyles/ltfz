package cn.momyles.ltfz.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.core.Controller;

import cn.momyles.ltfz.util.SecurityUtil;
/**
 * ΢��Web API
 * @author MoMyles
 * @date 2015-11-21
 */
public class WXController extends Controller {
	private static final Logger log = LoggerFactory.getLogger(WXController.class);
	private static final String TOKEN = "ltfz";
	public void index() {
		// �жϵ�ǰ�����Ƿ�ΪGET����
		if ("GET".equals(getRequest().getMethod())) {
			doGet();
		} else {
			doPost();
		}
	}
	/**
	 * POST,������Ϣ������
	 */
	private void doPost() {
		
	}
	/**
	 * GET����,����΢��
	 */
	private void doGet() {
		// ����URL GET�������
		String signature = getPara("signature");
		String timestamp = getPara("timestamp");
		String nonce = getPara("nonce");
		String echostr = getPara("echostr");
		// ��token��timestamp��nonce�������������ֵ�������
		String[] arr = new String[] {TOKEN,timestamp, nonce};
		Arrays.sort(arr);
		// �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {// ƴ���ַ���
			sb.append(arr[i]);
		}
		String CheckStr = "";
		try {
			CheckStr = SecurityUtil.encryptionOnSHA1(sb.toString());// SHA1����
		} catch (NoSuchAlgorithmException e) {
			log.error("���ܴ���");
		}
		// ��ȷ�ϴ˴�GET��������΢�ŷ�����������echostr��������
		if (CheckStr.equals(signature)) {
			renderText(echostr);
		}
	}
}
