package com.bawie.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.ReleaseMovieBean;
import com.bawie.movie.view.activity.GouPiaoActivity;
import com.bawie.movie.view.activity.ShowActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReleaseAdapter extends RecyclerView.Adapter {
    private List<ReleaseMovieBean.ResultBean> list;
    private Context context;
    private int movieId;


    public ReleaseAdapter(List<ReleaseMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.showitem_zheng, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.textView_fen.setText(list.get(position).getScore()+"分");
        viewHolder.textView_name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImageUrl()).into(viewHolder.imageView_showitem);
        movieId = list.get(position).getMovieId();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("name",list.get(position).getImageUrl());
                intent.putExtra("name1",list.get(position).getScore()+"");
              //  intent.putExtra("name2",list.get(position).getName());
               // intent.putExtra("movieId",movieId);
                context.startActivity(intent);
            }
        });
        viewHolder.but_gou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GouPiaoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_showitem;
        TextView textView_fen;
        TextView textView_name;
        Button but_gou;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_showitem = itemView.findViewById(R.id.imageView_showitem);
            but_gou = itemView.findViewById(R.id.but_gou);

            textView_fen = itemView.findViewById(R.id.textView_fen);
            textView_name = itemView.findViewById(R.id.textView_name);

        }
    }
}
