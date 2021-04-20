package com.example.newrxjava.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newrxjava.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class adepter extends RecyclerView.Adapter<adepter.viewholder> {
   ArrayList<postmodel> listdata = new ArrayList<>();

    public ArrayList<postmodel> getListdata() {
        return listdata;
    }

    public void setListdata(ArrayList<postmodel> listdata) {
        this.listdata = listdata;
    }

    public class viewholder  extends RecyclerView.ViewHolder {
       TextView title;
       TextView id;
       TextView body;
       public viewholder(View vv){
           super(vv);
           title = vv.findViewById(R.id.title);
           id = vv.findViewById(R.id.idd);
           body = vv.findViewById(R.id.body);
       }
   }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itempost,null , false);
        viewholder vh= new viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
postmodel posts = listdata.get(position);
holder.title.setText(posts.getTitle());
holder.id.setText(posts.getId());
holder.body.setText(posts.getBody());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
