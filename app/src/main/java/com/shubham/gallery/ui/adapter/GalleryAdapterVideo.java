package com.shubham.gallery.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shubham.gallery.R;

import java.util.List;

public class GalleryAdapterVideo extends RecyclerView.Adapter<GalleryAdapterVideo.ViewHolder> {

    private Context context;
    private List<String> images;
    protected PhotoListener photoListener;

    public GalleryAdapterVideo(Context context, List<String> images, PhotoListener photoListener) {
        this.context = context;
        this.images = images;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_layout_video, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String videoPath = images.get(position);
        Glide.with(context).load(videoPath).into(holder.imageVideo);
        holder.itemView.setOnClickListener(v -> photoListener.onPhotoClicked(videoPath));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageVideo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVideo = itemView.findViewById(R.id.ivImageItemViewVideo);
        }
    }

    public interface PhotoListener {
        void onPhotoClicked(String path);
    }
}
