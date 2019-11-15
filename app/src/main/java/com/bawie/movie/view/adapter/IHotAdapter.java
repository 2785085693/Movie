package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IHotAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HotMovieBean.ResultBean> listh;


    public IHotAdapter(Context context, List<HotMovieBean.ResultBean> list) {
        this.context = context;
        this.listh = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.showitem2, null);
        ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.textview3.setText(listh.get(position).getName());
        viewHolder.textview4.setText(listh.get(position).getScore() + "分");
         Glide.with(context).load(listh.get(position).getImageUrl()).into(viewHolder.imageView_showitem);
    }

    @Override
    public int getItemCount() {
        return listh.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView_showitem;
        TextView textview3;
        TextView textview4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_showitem = itemView.findViewById(R.id.imageView_showitem);
            textview3 = itemView.findViewById(R.id.textview3);
            textview4 = itemView.findViewById(R.id.textview4);

        }
    }
}
