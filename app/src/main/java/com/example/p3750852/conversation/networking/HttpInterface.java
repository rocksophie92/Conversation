package com.example.p3750852.conversation.networking;

import com.example.p3750852.conversation.LoginModel;
import com.example.p3750852.conversation.models.Login;
import com.example.p3750852.conversation.models.PingSound;
import com.example.p3750852.conversation.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * Created by Patrik on 2017. 03. 17..
 */
public interface HttpInterface {

    @POST("ping-user/login/emailpass")
    Call<User> loginPingUser(@Body LoginModel login);

    @POST("ping-user/new")
    Call<User> register(@Body User login);

@POST("message/ping")
    Call<MessageResponse> sendPing(@Body PingSound pingSound);

}
