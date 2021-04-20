package com.example.newrxjava.data;
import com.example.newrxjava.ui.main.postmodel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface postinterface {
   @GET("posts")
    public Observable<List<postmodel>> getposts();

}
