package com.example.my.android_textinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Toolbar login_toolbar;
    private EditText user;
    private EditText pass;
    private TextInputLayout inputlayout2;
    private TextInputLayout inputlayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //调用初始化UI控件的方法
        initView();
        setSupportActionBar(login_toolbar);
        //显示toolbar上隐藏的返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //给返回按钮设置监听事件，实现返回功能
        login_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //调用监听文本输入框的方法
        editTextChage();
    }

    private void editTextChage() {
        //给文本编辑设置输入内容的监听
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //如果用户输入的内容长度小于4将会提示用户，否则不进行任何的提示
                if (s.length()<4){
                    inputlayout1.setErrorEnabled(true);
                    inputlayout1.setError("用户名不合法");
                }else{
                    inputlayout1.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //如果用户输入的内容长度小于4将会提示用户，否则不进行任何的提示
                if (s.length()<4){
                    inputlayout2.setErrorEnabled(true);
                    inputlayout1.setError("密码不合法");
                }else{
                    inputlayout2.setErrorEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

    private void initView() {
        login_toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        inputlayout2 = (TextInputLayout) findViewById(R.id.inputlayout2);
        inputlayout1 = (TextInputLayout) findViewById(R.id.inputlayout1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                String username = user.getText().toString().trim();
                String password = pass.getText().toString().trim();

                //判断输入的用户名是否为空，为空将提示用户
                if (username.equals("")) {
                    inputlayout1.setError("用户名不能为空");
                } else {
                    inputlayout1.setErrorEnabled(false);
                }
                //判断输入的密码是否为空，为空将提示用户
                if (password.equals("")) {
                    inputlayout2.setError("密码不能为空");
                } else {
                    inputlayout1.setErrorEnabled(false);;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
