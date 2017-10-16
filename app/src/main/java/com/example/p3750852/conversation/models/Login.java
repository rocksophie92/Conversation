package com.example.p3750852.conversation.models;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.example.p3750852.conversation.LoginModel;
import com.example.p3750852.conversation.R;
import com.example.p3750852.conversation.models.BaseActivity;
import com.example.p3750852.conversation.models.ErrorWrapper;
import com.example.p3750852.conversation.models.User;
import com.example.p3750852.conversation.networking.RequestCallback;
import com.example.p3750852.conversation.networking.RequestRunner;
import com.example.p3750852.conversation.networking.RetrofitMain;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by P3750852 on 2017.08.24..
 */

public class Login extends BaseActivity {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.login_button_fb)
    Button LoginButtonFb;

    public static final String emailAd = "email";
    public static final String emailAddress = "emaiil";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void checkLogin() {
        // TODO mezők validálása
        // TODO szerverhívás - felküldendő modell összeállítása, hívás végrehajtása, válasz feldolgozása

        LoginModel login = new LoginModel();
        login.setEmail(email.getText().toString());

        login.setPassword(password.getText().toString());

        if (email.getText().toString().length() < 3
                || email.getText().toString().length() > 100
                //|| email.getText().toString().contains("@")
                ) {
            showToast("Invalid email");
            return;
        }

        if (password.getText().toString().length() < 3
                || password.getText().toString().length() > 100
             //   || email.getText().toString().contains("@")
                ) {
            showToast("Password must be between 2 and 100 characters long");
            return;
        }


        new RequestRunner<User>().sendRequest(new RetrofitMain().get().loginPingUser(login), new RequestCallback<User>() {
            @Override
            public void responseReceived(ErrorWrapper r, User o) {
                if (r != null) {
                    showToast(r.getMessage());
                }
                if (o != null) {
                    finish();
                }
            }
        });

        // TODO navigáció --> login: modell összerakása, validálás, hívás, feldolgozás
        // startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
