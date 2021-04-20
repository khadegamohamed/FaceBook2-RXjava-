package com.example.newrxjava.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.newrxjava.data.postclient;
import io.reactivex.rxjava3.core.Observable;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class postviewmodel extends ViewModel {

MutableLiveData<List<postmodel>>model  = new MutableLiveData<>();
CompositeDisposable comdisposable = new CompositeDisposable();
public void getpostss(){
     Log.d("mainactivity", "getpostss: ");
     Observable<List<postmodel>> observablee = postclient.getINSTINC().getposts()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread());
    comdisposable.add(observablee.subscribe(o -> model.setValue(o),e -> Log.d("MAIN_AVTIVTY", "getpostss: mainactivty"+e)));
}

     @Override
     protected void onCleared() {
          super.onCleared();
          comdisposable.clear();
     }
}
