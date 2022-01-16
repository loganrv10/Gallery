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
import com.squareup.picasso.Picasso;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context;
    private List<String> images;
    protected PhotoListener photoListener;

    public GalleryAdapter(Context context, List<String> images, PhotoListener photoListener) {
        this.context = context;
        this.images = images;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String image = images.get(position);
        Picasso.get()
                .load(image)
                .resize(300, 150)
                .centerCrop()
                .into(holder.image);

//        Glide.with(context).load(image).into(holder.image);
        holder.itemView.setOnClickListener(v -> photoListener.onPhotoClicked(image));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivImageItemView);
        }
    }

    public interface PhotoListener {
        void onPhotoClicked(String path);
    }
}
