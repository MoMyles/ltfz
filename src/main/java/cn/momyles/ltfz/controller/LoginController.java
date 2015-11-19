package cn.momyles.ltfz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
	// 记录日志信息
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	public void index() {
		log.warn(new String("Hello SomeBody My Log4j!"));
		renderText("Hello My First JFinal!");
	}
}
