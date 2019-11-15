package com.bawie.movie.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.presenter.BasePresenter;
import com.bawie.movie.view.activity.FeedBackActivity;
import com.bawie.movie.view.activity.MainActivity;

public class FragmentThree extends BaseFragment{
    private ImageView iv_my_moreAndmore;
    private TextView feedback;

    @Override
    void initData() {

    }

    @Override
    BasePresenter setFragment() {
        return new BasePresenter();
    }

    @Override
    void initView() {
        iv_my_moreAndmore = inflate.findViewById(R.id.iv_my_moreAndmore);
        feedback = inflate.findViewById(R.id.feedback);

        iv_my_moreAndmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(getContext(), FeedBackActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    int initLayout() {
        return R.layout.fragthree;
    }
}
