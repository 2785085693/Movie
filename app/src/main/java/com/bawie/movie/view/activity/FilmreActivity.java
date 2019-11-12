package com.bawie.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;

public class FilmreActivity extends BaseActivity {
    private Button commit;

    @Override
    void initData() {

    }

    @Override
    BasePresenter setPresenter() {
        return new BasePresenter();
    }

    @Override
    void initView() {
        commit = findViewById(R.id.commit);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FilmreActivity.this, ShowActivity.class);
                startActivity(intent);
                Toast.makeText(FilmreActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    int initLayout() {
        return R.layout.filmre;
    }


}
