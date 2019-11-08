package com.bawie.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity {


    private TextView textView_name;
    private TextView textView_regin;
    private Button login;

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
