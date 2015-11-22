package cn.momyles.ltfz.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import cn.momyles.ltfz.controller.LoginController;
import cn.momyles.ltfz.controller.WXController;
import cn.momyles.ltfz.pojo.ProList;
/**
 * My JFinal Config Class
 * @author MoMyles
 *
 */
public class MyJFinalConfig extends JFinalConfig {
	
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}
	
	@Override
	public void configRoute(Routes me) {
		// 登录路由
		me.add("/login", LoginController.class, "/");
		// 微信路由
		me.add("/weixin", WXController.class);
	}
	
	@Override
	public void configPlugin(Plugins me) {
		// 读取配置文件
		Prop prop = PropKit.use("jdbcConfig.properties");
		// 将参数放入C3p0构造器,实例化c3pPlugin
		C3p0Plugin cp = new C3p0Plugin(prop.get("jdbcUrl"), prop.get("user"), prop.get("password")
				, prop.get("driverClass"), prop.getInt("maxPoolSize"),prop.getInt("minPoolSize")
				, prop.getInt("initialPoolSize"), prop.getInt("maxIdleTime")
				, prop.getInt("acquireIncrement"));
		me.add(cp);// 添加c3p0插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);// 添加操作记录插件
		//-----表与模型映射
		// 产品列表映射
		arp.addMapping("product_list", "pl_id", ProList.class);
	}

	@Override
	public void configHandler(Handlers me) {
	}

	@Override
	public void configInterceptor(Interceptors me) {
	}
}
