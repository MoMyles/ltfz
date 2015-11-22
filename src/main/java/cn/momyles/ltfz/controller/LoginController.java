package cn.momyles.ltfz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.core.Controller;

import cn.momyles.ltfz.pojo.ProList;
import cn.momyles.ltfz.service.IProListService;
import cn.momyles.ltfz.service.impl.ProListServiceImpl;

public class LoginController extends Controller {
	// 日志输出对象
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	public void index() {
		IProListService ips = new ProListServiceImpl();
		// 测试新增产品
		ProList pl = new ProList();
		pl.set("pl_code", "test1").set("pl_class", 1).set("pl_name", "测试").set("pl_image", "../img")
			.set("pl_weight", 1).set("pl_size", 1).set("pl_material", "111").set("pl_desc", "册册册册")
			.set("pl_state", 1);
		//ips.save(pl);
		System.out.println(ips.findById(4));
		renderText("新增成功");
	}
}
