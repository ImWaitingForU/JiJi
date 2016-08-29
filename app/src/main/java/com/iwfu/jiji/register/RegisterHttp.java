package com.iwfu.jiji.register;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * 模拟注册的model层
 */
public class RegisterHttp {

	private static RegisterHttp registerHttp;

	private RegisterHttp() {

	}

	public synchronized static RegisterHttp getInstance() {
		if (registerHttp == null) {
			registerHttp = new RegisterHttp();
		}
		return registerHttp;
	}

	/**
	 * 获取验证码
	 */
	public void getVerifyCode() {

	}

	/**
	 * 模拟注册
	 * 
	 * @return true：注册成功/false:注册失败
	 */
	public boolean httpRegister(String verify) {

		if (verify.equals("1234")) {
			return true;
		}

		return false;
	}

}
