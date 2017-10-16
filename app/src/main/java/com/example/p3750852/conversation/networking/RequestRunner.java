package com.example.p3750852.conversation.networking;

import com.example.p3750852.conversation.models.ErrorWrapper;

import retrofit2.Call;

/**
 *
 * Created by Patrik on 2016. 08. 09..
 */
public class RequestRunner<T> {
    public void sendRequest(final Call<T> call, final RequestCallback<T> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                T t;
                try {

                    retrofit2.Response<T> t1 = call.execute();
                    //TODO check error
                    if (t1.code() != 200) {
                        ErrorWrapper e = RetrofitMain.getGson().fromJson(t1.errorBody().string(), ErrorWrapper.class);

                        if (e.loginRequired()) {
                            callback.responseReceived(new ErrorWrapper("0.0", 0, "Login required"), null);
                            return;
                        }
                        callback.responseReceived(e, null);
                        return;

                    }
                    t = t1.body();
                    if (t != null) {
                        callback.responseReceived(null, t);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ErrorWrapper r = new ErrorWrapper("0.0", 0, "Unknown error");
                    callback.responseReceived(r, null);
                }
            }
        }).start();
    }

}
