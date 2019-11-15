package com.bawie.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.wxapi.MyApplication;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import java.util.UUID;

public class MainActivity extends BaseActivity {


    private TextView textView_name;
    private TextView textView_regin;
    private Button login;
    private ImageView wx;
    private EditText editName;
    private EditText editEmail;

    @Override
    void initData() {

    }

    @Override
    BasePresenter setPresenter() {
        return new BasePresenter();
    }

    @Override
    void initView() {
        login = findViewById(R.id.login);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        wx = findViewById(R.id.wx);
        wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = UUID.randomUUID().toString();
                MyApplication.getWXApi().sendReq(req);
                Intent intent = new Intent(MainActivity.this, TabActivity.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    int initLayout() {
        return R.layout.activity_main;
    }


}
