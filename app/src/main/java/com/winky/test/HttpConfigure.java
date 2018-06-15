package com.winky.test;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpConfigure {

    private final HttpUrl httpUrl;
    private final Call.Factory callFactory;
    private final Retrofit retrofit;

    public HttpConfigure(HttpUrl httpUrl, Call.Factory callFactory, Retrofit retrofit) {
        this.httpUrl = httpUrl;
        this.callFactory = callFactory;
        this.retrofit = retrofit;
    }

    public HttpUrl getHttpUrl() {
        return httpUrl;
    }

    public Call.Factory getCallFactory() {
        return callFactory;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class Builder {
        private HttpUrl httpUrl;
        private Call.Factory callFactory;
        private Retrofit retrofit;

        public Builder baseUrl(String url) {
            httpUrl = HttpUrl.parse(url);
            return this;
        }

        public Builder callFactory(Call.Factory callFactory) {
            this.callFactory = callFactory;
            return this;
        }

        public Builder retrofit(Retrofit retrofit) {
            this.retrofit = retrofit;
            return this;
        }

        public HttpConfigure build() {
            if (httpUrl == null) {
                throw new IllegalArgumentException("httpUrl must be not empty");
            }
            if (callFactory == null) {
                callFactory = new OkHttpClient();
            }
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(httpUrl)
                        .callFactory(callFactory)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

            return new HttpConfigure(httpUrl, callFactory, retrofit);
        }
    }
}
