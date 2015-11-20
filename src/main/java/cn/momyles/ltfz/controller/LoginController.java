package cn.momyles.ltfz.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
	// 记录日志信息
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	public void index() {
		setAttr("name", null);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		setAttr("list", list);
		renderFreeMarker("index.flt");
	}
}
