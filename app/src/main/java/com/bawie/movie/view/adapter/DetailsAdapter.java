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

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsAdapter extends RecyclerView.Adapter {
    private List<DetailsBean.ResultBean.MovieDirectorBean> list;
    private Context context;

    public DetailsAdapter(List<DetailsBean.ResultBean.MovieDirectorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.foreitem, null);
        final ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.fore_jie.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getPhoto()).into(viewHolder.fore_ImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fore_ImageView;
        TextView fore_jie;

        //  RecyclerView foreitem_recyclerview;
        // RecyclerView perform_recyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fore_jie = itemView.findViewById(R.id.fore_jie);
            fore_ImageView = itemView.findViewById(R.id.fore_ImageView);
            // foreitem_recyclerview = itemView.findViewById(R.id.foreitem_recyclerview);
            // perform_recyclerview = itemView.findViewById(R.id.perform_recyclerview);
        }
    }
}
