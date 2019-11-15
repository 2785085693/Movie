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

public class DetailsAdapter1 extends RecyclerView.Adapter {
    private List<DetailsBean.ResultBean.MovieActorBean> list;
    private Context context;

    public DetailsAdapter1(List<DetailsBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.foreitem2, null);
        final ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.fore_jie.setText(list.get(position).getName());
        viewHolder.fore_jie1.setText("饰"+" "+list.get(position).getRole());
        Glide.with(context).load(list.get(position).getPhoto()).into(viewHolder.fore_ImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fore_ImageView;
        TextView fore_jie;
        TextView fore_jie1;

        //  RecyclerView foreitem_recyclerview;
        // RecyclerView perform_recyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fore_jie = itemView.findViewById(R.id.fore_jie);
            fore_jie1 = itemView.findViewById(R.id.fore_jie1);
            fore_ImageView = itemView.findViewById(R.id.fore_ImageView);


        }
    }
}
