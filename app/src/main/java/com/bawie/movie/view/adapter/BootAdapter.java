package com.bawie.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawie.movie.R;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.model.bean.HotMovieBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BootAdapter extends RecyclerView.Adapter {
    private List<DetailsBean.ResultBean> list;
    private Context context;

    public BootAdapter(List<DetailsBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bootitem, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = new ViewHolder(holder.itemView);
        viewHolder.bootname.setText(list.get(position).getName());
        viewHolder.boot11.setText(list.get(position).getMovieType());
        viewHolder.bootname22.setText(list.get(position).getPlaceOrigin());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView bootname;
        TextView boot11;
        TextView bootname22;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bootname = itemView.findViewById(R.id.bootname);
            boot11 = itemView.findViewById(R.id.boot11);
            bootname22 = itemView.findViewById(R.id.bootname22);
        }
    }
}
