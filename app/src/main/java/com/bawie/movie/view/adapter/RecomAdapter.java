package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.RecomBean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecomAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RecomBean.ResultBean> list;


    public RecomAdapter(Context context, List<RecomBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.recomitem, null);
        final ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.text_recom.setText(list.get(position).getName());
        viewHolder.text_recom1.setText(list.get(position).getAddress());
        Glide.with(context).load(list.get(position).getLogo()).into(viewHolder.recom_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recom_image;
        TextView text_recom;
        TextView text_recom1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_recom = itemView.findViewById(R.id.text_recom);
            text_recom1 = itemView.findViewById(R.id.text_recom1);
            recom_image = itemView.findViewById(R.id.recom_image);
        }
    }
}
