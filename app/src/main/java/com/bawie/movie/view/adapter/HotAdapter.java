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

public class HotAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HotMovieBean.ResultBean> listh;



    public HotAdapter(Context context, List<HotMovieBean.ResultBean> list) {
        this.context = context;
        this.listh = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragitem_men, null);
        ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      //  final ViewHolder viewHolder = new ViewHolder(holder.itemView);
     //  viewHolder.textview1.setText(listh.get(position).getName());
     //   viewHolder.textview2.setText(listh.get(position).getScore()+"分");
       // Glide.with(context).load(listh.get(position).getHorizontalImage()).into(viewHolder.imageView_show);
    }

    @Override
    public int getItemCount() {
        return listh.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imageView_show;
        private TextView textview1;
        private TextView textview2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_show = itemView.findViewById(R.id.imageView_show);
           // textview1 = itemView.findViewById(R.id.textview1);
           // textview2 = itemView.findViewById(R.id.textview2);

        }
    }
}
