package cn.lmtoo.core.tools;

import java.io.IOException;
import java.util.Properties;

/**
 * PEAA插件模式<br>
 * 插件工厂<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月17日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class Plugins {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ClassLoader.getSystemResourceAsStream("plugins.properties"));
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <P> P getPlugin(Class<P> clazz) {
		String implName = props.getProperty(clazz.getName());
		if (implName == null) {
			throw new RuntimeException("implementation not specified for " + clazz.getName() + " in PluginFactory propeties.");
		}
		try {
			return (P) Class.forName(implName).newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("factory unable to construct instance of " + clazz.getName());
		}
	}
}