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
import cn.momyles.ltfz.pojo.User;
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
		me.add("/login", LoginController.class, "/");
	}
	
	@Override
	public void configPlugin(Plugins me) {
		// 读取数据库配置文件
		Prop prop = PropKit.use("jdbcConfig.properties");
		// 将配置参数传入C3p0
		C3p0Plugin cp = new C3p0Plugin(prop.get("jdbcUrl"), prop.get("user"), prop.get("password")
				, prop.get("driverClass"), prop.getInt("maxPoolSize"),prop.getInt("minPoolSize")
				, prop.getInt("initialPoolSize"), prop.getInt("maxIdleTime")
				, prop.getInt("acquireIncrement"));
		me.add(cp);// 添加c3p0插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		arp.addMapping("user", User.class);
	}

	@Override
	public void configHandler(Handlers me) {
	}

	@Override
	public void configInterceptor(Interceptors me) {
	}
}
