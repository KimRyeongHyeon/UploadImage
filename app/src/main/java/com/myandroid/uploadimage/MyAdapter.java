package com.myandroid.uploadimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ModelImage> imageList;

    public MyAdapter(Context context, List<ModelImage> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(imageList.get(position).getImageurl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}