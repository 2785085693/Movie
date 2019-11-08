package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.ComingMovieBean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ComingAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ComingMovieBean.ResultBean> listc;


    public ComingAdapter(Context context, List<ComingMovieBean.ResultBean> list) {
        this.context = context;
        this.listc = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.showitem1, null);
        ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.show_name.setText(listc.get(position).getName());

        Glide.with(context).load(listc.get(position).getImageUrl()).into(viewHolder.imageView_1);
    }

    @Override
    public int getItemCount() {
        return listc.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_1;
        TextView show_name;
        TextView show_time;
        TextView show_ren;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            show_name = itemView.findViewById(R.id.show_name);
            show_time = itemView.findViewById(R.id.show_time);
            show_ren = itemView.findViewById(R.id.show_ren);
            imageView_1 = itemView.findViewById(R.id.imageView_1);
        }
    }
}
