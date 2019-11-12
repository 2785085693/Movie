package com.bawie.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// 引导页的跳转点击事情
public class GuideActivity extends BaseActivity {

    private int variabel =4;
    private Timer timer;

    private TextView mTime;

    @Override
    void initData() {

    }

    @Override
    BasePresenter setPresenter() {
        return new BasePresenter();
    }

    @Override
    void initView() {
        mTime = findViewById(R.id.guide);
        delay();
    }

    @Override
    int initLayout() {
        return R.layout.guide;
    }

    //  倒计时
    private void delay() {
        timer = new Timer();
       TimerTask timerTask = new TimerTask() {
              @Override
              public void run() {
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          if (variabel != 0) {
                              variabel--;
                              mTime.setText(variabel + "");
                              Log.d("fff",variabel+"");
                              return;
                          } else {
                              timer.cancel();
                              startActivity(new Intent(GuideActivity.this, TabActivity.class));
                              finish();
                          }
                      }
                  });
              }
          };
        timer.schedule(timerTask, 0, 1000);
    }
}
