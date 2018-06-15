package com.winky.test;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IArticle {
    @GET("wx/article/category/query")
    Observable<ApiModel<List<ArticleType>>> queryArticle(@Query("key") String key);
}
