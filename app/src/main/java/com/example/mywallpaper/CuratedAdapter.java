package com.example.mywallpaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mywallpaper.Interfaces.onRecyclerClickListener;
import com.example.mywallpaper.Models.Photo;

import java.util.List;

public class CuratedAdapter extends RecyclerView.Adapter<CuratedAdapter.CuratedViewHolder> {
    private List<Photo> photoList;
    private final Context context;
    private onRecyclerClickListener listener;

    public CuratedAdapter(Context context, List<Photo> photoList, onRecyclerClickListener listener) {
        this.context = context;
        this.photoList = photoList;
        this.listener = listener;
    }
    
    @NonNull
    @Override
    public CuratedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_layout_home_list, parent, false);
        return new CuratedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuratedViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        Glide.with(context).load(photo.getSrc().getOriginal()).placeholder(R.drawable.placeholder).into(holder.home_list_imageView);
        holder.home_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(photoList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public static class CuratedViewHolder extends RecyclerView.ViewHolder {
        CardView home_list_container;
        ImageView home_list_imageView;

        public CuratedViewHolder(@NonNull View itemView) {
            super(itemView);
            home_list_container = itemView.findViewById(R.id.home_list_container);
            home_list_imageView = itemView.findViewById(R.id.home_list_imageView);
        }
    }

}
