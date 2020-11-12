package com.example.mydairy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    private String realCode;
    private DBOpenHelper mDBOpenHelper;
    private Button mBtRegisteractivityRegister;
    private EditText mEtRegisteractivityUsername;
    private EditText mEtRegisteractivityPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        initView();

        mDBOpenHelper = new DBOpenHelper(this);

    }

    private void initView(){
        mBtRegisteractivityRegister = findViewById(R.id.btn_register);
        mEtRegisteractivityUsername = findViewById(R.id.e_user_name2);
        mEtRegisteractivityPassword2 = findViewById(R.id.e_user_pwd2);


        /**
         * 注册页面能点击的就一个地方
         * 注册按钮
         */

        mBtRegisteractivityRegister.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_register:    //注册按钮
                //获取用户输入的用户名、密码
                String username = mEtRegisteractivityUsername.getText().toString().trim();
                String password = mEtRegisteractivityPassword2.getText().toString().trim();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) ) {

                        //将用户名和密码加入到数据库中
                        mDBOpenHelper.add(username, password);
                        Intent intent2 = new Intent(this, LoginActivity.class);
                        startActivity(intent2);
                        finish();
                        Toast.makeText(this,  "注册成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

