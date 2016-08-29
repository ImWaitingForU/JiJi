package com.iwfu.jiji.login;

import com.iwfu.jiji.util.BasePresenter;
import com.iwfu.jiji.util.BaseView;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * 登录功能的契约类，包含view和presenter接口
 */
public class LoginContract {

	public interface View extends BaseView<Presenter> {
		String getAccount();
		String getPassword();

		/**
		 * 登陆成功后ui的改变
		 */
		void loginSuccess();

		/**
		 * 登录失败后ui的改变
		 * 
		 * @param msg
		 *            返回的错误信息
		 */
		void loginError(String msg);
	}

	public interface Presenter extends BasePresenter {
		void login();
	}

}
