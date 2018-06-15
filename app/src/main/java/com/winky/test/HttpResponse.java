package com.winky.test;

public interface HttpResponse<T> {

    void success(T result);

    void failed(Throwable throwable);
}
