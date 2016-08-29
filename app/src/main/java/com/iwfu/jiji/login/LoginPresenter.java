package com.iwfu.jiji.login;

import android.text.TextUtils;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * 登录功能的presenter
 */
public class LoginPresenter implements LoginContract.Presenter {

	private LoginContract.View view;

	public LoginPresenter(LoginContract.View view) {
		this.view = view;
	}

	@Override
	public void login() {
		if (!validate()) {
			return;
		}

		boolean result = LoginHttp.getInstance().httpLogin(view.getAccount(),
				view.getPassword());
		if (result) {
			view.loginSuccess();
		} else {
			view.loginError("登录失败，请检查用户名或密码");
		}
	}

	@Override
	public void start() {

	}

	/**
	 * 账号密码非空验证
	 * 
	 * @return
	 */
	public boolean validate() {
		if (TextUtils.isEmpty(view.getAccount())) {
			view.loginError("用户名不能为空");
			return false;
		}

		if (TextUtils.isEmpty(view.getPassword())) {
			view.loginError("密码不能为空");
			return false;
		}

		return true;
	}

}
