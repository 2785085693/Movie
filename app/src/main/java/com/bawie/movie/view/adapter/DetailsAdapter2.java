package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.DetailsBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsAdapter2 extends RecyclerView.Adapter {

    private List<DetailsBean.ResultBean> list;

    private Context context;

    public DetailsAdapter2(List<DetailsBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.foreitem1, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.fore_jie.setText(list.get(position).getSummary());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView fore_jie;

        //  RecyclerView foreitem_recyclerview;
        // RecyclerView perform_recyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fore_jie = itemView.findViewById(R.id.fore_jie);

        }
    }
}
