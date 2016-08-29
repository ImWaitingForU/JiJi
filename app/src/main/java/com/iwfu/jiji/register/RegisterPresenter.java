package com.iwfu.jiji.register;

import android.text.TextUtils;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * 注册的presenter
 */
public class RegisterPresenter implements RegisterContract.Presenter {

	private RegisterContract.View view;
	private RegisterHttp registerHttp;

	public RegisterPresenter(RegisterContract.View view) {
		this.view = view;
		registerHttp = RegisterHttp.getInstance();
	}

	@Override
	public void getVerify() {
		// TODO 获取验证码
        registerHttp.getVerifyCode();
		view.getVerifyCode ();
	}

	@Override
	public void register() {
		// TODO 注册
		if (!validate(view.getAccount(), view.getVerify(), view.getPwd(),
				view.getRepeatPwd())) {
			return;
		}

		boolean result = registerHttp.httpRegister(view.getVerify());

		if (result) {
			view.registerSuccess();
		} else {
			view.registerError("注册失败");
		}

	}

	@Override
	public void start() {

	}

	/**
	 * 判断数据是否有效
	 */
	private boolean validate(String account, String verify, String pwd,
			String repeatPwd) {

		if (TextUtils.isEmpty(account)) {
			view.registerError("手机号不能为空");
			return false;
		}

		if (TextUtils.isEmpty(verify)) {
			view.registerError("验证码不能为空");
			return false;
		}

		if (TextUtils.isEmpty(pwd)) {
			view.registerError("密码不能为空");
			return false;
		}

		if (TextUtils.isEmpty(repeatPwd)) {
			view.registerError("重复密码不能为空");
			return false;
		}

		/**
		 * 验证密码是否一致
		 */
		if (repeatPwd.equals(pwd)) {
			view.registerError("两次输入密码不一致");
			return false;
		}

		return true;
	}
}
