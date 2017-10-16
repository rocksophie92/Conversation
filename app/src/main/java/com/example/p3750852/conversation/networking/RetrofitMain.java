package com.example.p3750852.conversation.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * Created by Patrik on 2016. 08. 07..
 */
public class RetrofitMain {
    public static final String BASE_URL = "https://159.203.90.4:49106/ping/rest/0.1/";

    public HttpInterface get() {
        return get(true);
    }
    public HttpInterface get(boolean jsonConverter) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient()
        .addInterceptor(new Interceptor() {
                                      @Override
                                      public Response intercept(Chain chain) throws IOException {
                                          Request original = chain.request();

                                          Request.Builder requestBuilder = original.newBuilder()
                                                  .header("Content-type", "application/json")
                                                  .method(original.method(), original.body());
                                          String token = getAccessToken();
                                          if (token != null) {
                                              requestBuilder.header("accessToken", getAccessToken());
                                          }
                                          return chain.proceed(requestBuilder.build());
                                      }
        }).build();
        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client);
        if (jsonConverter) {
            retrofit.addConverterFactory(GsonConverterFactory.create(getGson()));
        }

        return retrofit.build().create(HttpInterface.class);
    }

    private String getAccessToken() {
        return new DataStore().getToken();
    }

    public static Gson getGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    public static String getCouponImage(String imageId) {
        return BASE_URL + "image/coupon/" + imageId;
    }
    public static String getCategoryImage(String imageId) {
        return BASE_URL + "image/category/" + imageId;
    }
//    public static AgenciesHttpInterface getRestEndpoint(){
//        if (restEndpoint != null)
//            return restEndpoint;
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://159.203.90.4:8080/geefiz/rest/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build();
//
//        return restEndpoint = retrofit.create(AgenciesHttpInterface.class);
//    }

    private static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}