package com.example.newrxjava.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newrxjava.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postviewmodel postmodel = ViewModelProviders.of(this).get(postviewmodel.class);
        postmodel.getpostss();
      recyler  = findViewById(R.id.recycler);
      adepter ad = new adepter();
      RecyclerView.LayoutManager im = new LinearLayoutManager(this);
      recyler.setLayoutManager(im);
      recyler.setAdapter(ad);
      recyler.setHasFixedSize(true);
postmodel.model.observe(this, new Observer<List<com.example.newrxjava.ui.main.postmodel>>() {
    @Override
    public void onChanged(List<com.example.newrxjava.ui.main.postmodel> postmodels) {
        ad.setListdata((ArrayList<postmodel>)postmodels);

    }
});
    }

}