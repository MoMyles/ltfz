package cn.momyles.ltfz.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.core.Controller;

import cn.momyles.ltfz.util.SecurityUtil;
/**
 * 微信Web API
 * @author MoMyles
 * @date 2015-11-21
 */
public class WXController extends Controller {
	private static final Logger log = LoggerFactory.getLogger(WXController.class);
	private static final String TOKEN = "ltfz";
	public void index() {
		// 判断当前请求是否为GET请求
		if ("GET".equals(getRequest().getMethod())) {
			doGet();
		} else {
			doPost();
		}
	}
	/**
	 * POST,接收消息并处理
	 */
	private void doPost() {
		
	}
	/**
	 * GET请求,接入微信
	 */
	private void doGet() {
		// 接入URL GET请求参数
		String signature = getPara("signature");
		String timestamp = getPara("timestamp");
		String nonce = getPara("nonce");
		String echostr = getPara("echostr");
		// 将token、timestamp、nonce三个参数进行字典序排序
		String[] arr = new String[] {TOKEN,timestamp, nonce};
		Arrays.sort(arr);
		// 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {// 拼接字符串
			sb.append(arr[i]);
		}
		String CheckStr = "";
		try {
			CheckStr = SecurityUtil.encryptionOnSHA1(sb.toString());// SHA1加密
		} catch (NoSuchAlgorithmException e) {
			log.error("加密错误");
		}
		// 若确认此次GET请求来自微信服务器，返回echostr参数内容
		if (CheckStr.equals(signature)) {
			renderText(echostr);
		}
	}
}
