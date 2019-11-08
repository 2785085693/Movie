package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.ReleaseMovieBean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter {

    private List<ReleaseMovieBean.ResultBean> list;
    private Context context;


    public MyAdapter(List<ReleaseMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.showitem3, null);
        ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.show_name.setText(list.get(position).getName());
        viewHolder.show_time.setText(list.get(position).getDirector());
        viewHolder.show_ren.setText(list.get(position).getStarring());
        viewHolder.show_ren1.setText(list.get(position).getScore()+"分");
        Glide.with(context).load(list.get(position).getImageUrl()).into(viewHolder.imageView_1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_1;
        TextView show_name;
        TextView show_time;
        TextView show_ren;
        TextView show_ren1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_1 = itemView.findViewById(R.id.imageView_1);
            show_name = itemView.findViewById(R.id.show_name);
            show_time = itemView.findViewById(R.id.show_time);
            show_ren = itemView.findViewById(R.id.show_ren);
            show_ren1 = itemView.findViewById(R.id.show_ren1);

        }
    }
}
