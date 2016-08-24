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
        initView();
        setSupportActionBar(login_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        login_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        editTextChage();
    }

    private void editTextChage() {
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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

                if (username.equals("")) {
                    inputlayout1.setError("用户名不能为空");
                } else {
                    inputlayout1.setErrorEnabled(false);
                }

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
