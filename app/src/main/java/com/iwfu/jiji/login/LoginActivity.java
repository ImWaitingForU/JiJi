package com.iwfu.jiji.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iwfu.jiji.R;
import com.iwfu.jiji.activity.MainActivity;
import com.iwfu.jiji.register.RegisterActivity;


/**
 * 使用MVP实现登录功能
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;
    private LoginPresenter presenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        initViews ();
        initParams ();
    }

    private void initViews () {
        TextInputLayout account = (TextInputLayout) findViewById (R.id.tilAccount);
        TextInputLayout pwd = (TextInputLayout) findViewById (R.id.tilPwd);
        assert account != null;
        etAccount = account.getEditText ();
        assert pwd != null;
        etPassword = pwd.getEditText ();

        Button btnLogin = (Button) findViewById (R.id.btnLogin);
        assert btnLogin != null;
        btnLogin.setOnClickListener (this);

        TextView tvGoRegister = (TextView) findViewById (R.id.tvGoRegister);
        assert tvGoRegister != null;
        tvGoRegister.setOnClickListener (this);
    }

    private void initParams () {
        presenter = new LoginPresenter (this);
    }

    @Override
    public String getAccount () {
        return etAccount.getText ().toString ();
    }

    @Override
    public String getPassword () {
        return etPassword.getText ().toString ();
    }

    @Override
    public void loginSuccess () {
        Toast.makeText (LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show ();
        startActivity (new Intent (LoginActivity.this, MainActivity.class));
        finish ();
    }

    @Override
    public void loginError (String msg) {
        Toast.makeText (LoginActivity.this, msg, Toast.LENGTH_SHORT).show ();
    }

    @Override
    public void setPresenter (LoginContract.Presenter presenter) {

    }

    @Override
    public void onClick (View v) {
        int id = v.getId ();
        if (id == R.id.btnLogin) {
            presenter.login ();
        } else if (id == R.id.tvGoRegister) {
            startActivity (new Intent (LoginActivity.this, RegisterActivity.class));
        }
    }
}
