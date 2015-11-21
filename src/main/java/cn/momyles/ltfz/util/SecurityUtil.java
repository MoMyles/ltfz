package cn.momyles.ltfz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密解密工具类
 * @author MoMyles
 * @date 2015-11-21
 */
public class SecurityUtil {
	/**
	 * SHA1加密
	 * @param str 原文
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptionOnSHA1(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(str.getBytes());
		byte[] bits = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bits.length; i++) {
			int t = bits[i];
			if (t < 0) {
				t += 256;
			}
			if (t < 16) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(t));
		}
		return sb.toString();
	}
}
