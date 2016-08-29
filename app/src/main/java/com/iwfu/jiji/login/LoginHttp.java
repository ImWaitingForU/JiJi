package com.iwfu.jiji.login;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * 网络通信进行登录
 */
public class LoginHttp {

	private LoginHttp() {

	}

	private static LoginHttp instance = null;

	public synchronized static LoginHttp getInstance() {
		if (instance == null) {
			instance = new LoginHttp();
		}
		return instance;
	}

	public boolean httpLogin(String account, String pwd) {
		// TODO 真实的网络通信登录验证
		if (account.equals("aaa") && pwd.equals("aaa")) {
			return true;
		}
		return false;
	}

}
