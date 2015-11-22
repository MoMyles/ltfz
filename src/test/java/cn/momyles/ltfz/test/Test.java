package cn.momyles.ltfz.test;

import cn.momyles.ltfz.pojo.ProList;
import cn.momyles.ltfz.service.IProListService;
import cn.momyles.ltfz.service.impl.ProListServiceImpl;
import junit.framework.TestCase;

public class Test extends TestCase {
	/**
	 * 产品列表测试
	 */
	public void testProListService() {
		IProListService ips = new ProListServiceImpl();
		// 测试新增一个产品
		ProList pl = new ProList();
		pl.set("pl_code", "test").set("pl_class", 1).set("pl_name", "����").set("pl_image", "../img")
			.set("pl_weight", 1).set("pl_size", 1).set("pl_material", "111").set("pl_desc", "����")
			.set("pl_state", 1);
		ips.save(pl);
	}
}
