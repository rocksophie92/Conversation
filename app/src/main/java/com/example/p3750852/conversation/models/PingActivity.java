package com.example.p3750852.conversation.models;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;


import com.example.p3750852.conversation.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by P3750852 on 2017.08.10..
 */

public class PingActivity extends BaseActivity {

    @BindView(R.id.ping_button)
    Button pingButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);


    }

  //  @OnClick(R.id.ping_button)


}
