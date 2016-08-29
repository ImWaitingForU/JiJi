package com.iwfu.jiji.register;

import com.iwfu.jiji.util.BasePresenter;
import com.iwfu.jiji.util.BaseView;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * 注册功能的契约类
 */
public class RegisterContract {

	interface View extends BaseView<Presenter> {
		String getAccount();
		String getVerify();
		String getPwd();
		String getRepeatPwd();

		void getVerifyCode(); //获取验证码按钮改变
		void registerError(String msg);
		void registerSuccess();
	}

	interface Presenter extends BasePresenter {
		/**
		 * 获取验证码
		 */
		void getVerify();

		void register();
	}

}
