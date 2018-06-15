package com.winky.test;

import android.os.Looper;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            HttpConfigure configure = new HttpConfigure.Builder().baseUrl(Config.SERVER_URL).build();
            HttpUtils.getInstance().setHttpConfigure(configure);
        }
    }
}
