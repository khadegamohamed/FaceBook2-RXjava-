package com.example.newrxjava.data;
import com.example.newrxjava.ui.main.postmodel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.converter.gson.GsonConverterFactory;

public class postclient {
    private static final String useui = "https://jsonplaceholder.typicode.com/";
    private postinterface postinter;
 private  static postclient INSTINC;
public postclient(){
    HttpLoggingInterceptor intercept = new HttpLoggingInterceptor();
    intercept.level(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient clientt = new OkHttpClient.Builder().addInterceptor(intercept).build();
    Retrofit retrof = new Retrofit.Builder().baseUrl(useui)
            .addConverterFactory(GsonConverterFactory.create()).client(clientt)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();
    postinter = retrof.create(postinterface.class);
}

    public static postclient getINSTINC() {
    if(null  == INSTINC){
        INSTINC = new postclient();
    }
        return INSTINC;
    }
    public Observable<List<postmodel>> getposts(){
 return postinter.getposts();
    }




}
