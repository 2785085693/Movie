package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.FindBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FindAdapter extends RecyclerView.Adapter {
    private List<FindBean.ResultBean> list;
    private Context context;


    public FindAdapter(List<FindBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.sevenitem, null);
        final ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        Glide.with(context).load(list.get(position).getCommentHeadPic())
                .apply(RequestOptions.circleCropTransform())
                .into(viewHolder.seven_img);
        viewHolder.name_seve.setText(list.get(position).getCommentContent());

        Date date = new Date(list.get(position).getCommentTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        viewHolder.text_time.setText(simpleDateFormat.format(date));
        viewHolder.text_fen.setText(list.get(position).getScore()+"分");
        viewHolder.text_pl.setText(list.get(position).getCommentUserName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView seven_img;
        TextView name_seve;
        TextView text_fen;
        TextView text_time;
        TextView text_pl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            seven_img = itemView.findViewById(R.id.seven_img);
            name_seve = itemView.findViewById(R.id.name_seve);
            text_fen = itemView.findViewById(R.id.text_fen);
            text_time = itemView.findViewById(R.id.text_time);
            text_pl = itemView.findViewById(R.id.text_pl);
        }
    }
}
