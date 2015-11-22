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
		// 判断是否为GET请求
		if ("GET".equals(getRequest().getMethod())) {
			doGet();
		} else {
			doPost();
		}
	}
	/**
	 * POST,微信操作处理
	 */
	private void doPost() {
		
	}
	/**
	 * GET微信接入操作
	 */
	private void doGet() {
		// 微信接入URL参数
		String signature = getPara("signature");
		String timestamp = getPara("timestamp");
		String nonce = getPara("nonce");
		String echostr = getPara("echostr");
		// 将token,timestamp,once进行数字字典排序
		String[] arr = new String[] {TOKEN,timestamp, nonce};
		Arrays.sort(arr);
		// sha1加密操作
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {// 拼接
			sb.append(arr[i]);
		}
		String CheckStr = "";
		try {
			CheckStr = SecurityUtil.encryptionOnSHA1(sb.toString());// SHA1加密
		} catch (NoSuchAlgorithmException e) {
			log.error("加密错误");
		}
		// 若检测到为微信接入,则返回echostr
		if (CheckStr.equals(signature)) {
			renderText(echostr);
		}
	}
}
