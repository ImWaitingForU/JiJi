package com.iwfu.jiji.register;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iwfu.jiji.R;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View, View.OnClickListener {

    private EditText etAccount;
    private EditText etVerify;
    private EditText etPwd;
    private EditText etRepeatPwd;
    private Button btnVerify;

    private static boolean isVerifing = false;

    private RegisterContract.Presenter presenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);
        initViews ();
        initParams ();
    }

    private void initViews () {
        TextInputLayout tilNewAccount = (TextInputLayout) findViewById (R.id.tilNewAccount);
        etAccount = tilNewAccount.getEditText ();

        TextInputLayout tileVerify = (TextInputLayout) findViewById (R.id.tilVerify);
        etVerify = tileVerify.getEditText ();

        TextInputLayout tilNewPwd = (TextInputLayout) findViewById (R.id.tilNewPwd);
        etPwd = tilNewPwd.getEditText ();

        TextInputLayout tilRepeatPwd = (TextInputLayout) findViewById (R.id.tilRepeatPwd);
        etRepeatPwd = tilRepeatPwd.getEditText ();

        btnVerify = (Button) findViewById (R.id.btnVerify);
        Button btnFinish = (Button) findViewById (R.id.btnFinish);

        btnVerify.setOnClickListener (this);
        btnFinish.setOnClickListener (this);
    }

    private void initParams () {
        presenter = new RegisterPresenter (this);
    }

    @Override
    public String getAccount () {
        return etAccount.getText ().toString ();
    }

    @Override
    public String getVerify () {
        return etVerify.getText ().toString ();
    }

    @Override
    public String getPwd () {
        return etPwd.getText ().toString ();
    }

    @Override
    public String getRepeatPwd () {
        return etRepeatPwd.getText ().toString ();
    }

    @Override
    public void getVerifyCode () {
        //TODO : 开始一个定时任务，一分钟之内按钮不可点击且倒计时
    }

    @Override
    public void registerError (String msg) {
        Toast.makeText (RegisterActivity.this, msg, Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void registerSuccess () {
        Toast.makeText (RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void setPresenter (RegisterContract.Presenter presenter) {

    }

    @Override
    public void onClick (View v) {
        int id = v.getId ();
        if (id == R.id.btnVerify) {
            presenter.getVerify ();
        } else if (id == R.id.btnFinish) {
            presenter.register ();
        }
    }
}
