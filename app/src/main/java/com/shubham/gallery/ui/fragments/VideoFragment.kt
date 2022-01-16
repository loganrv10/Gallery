package com.shubham.gallery.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.shubham.gallery.R
import com.shubham.gallery.databinding.FragmentVideoBinding
import com.shubham.gallery.ui.adapter.GalleryAdapterVideo
import com.shubham.gallery.viewmodels.ImageGalleryViewModel


class VideoFragment : Fragment() {


    private lateinit var videoFragmentImageBinding: FragmentVideoBinding
    var videos = listOf<String>()
    private lateinit var adapter: GalleryAdapterVideo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        videoFragmentImageBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_video,container,false)
        return videoFragmentImageBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadVideo()
    }

    private fun loadVideo() {
        videos = ImageGalleryViewModel.listOfVideos(context)
        videoFragmentImageBinding.apply {
            rvVideoView.setHasFixedSize(true)
            rvVideoView.layoutManager = GridLayoutManager(context, 2)
            adapter = GalleryAdapterVideo(
                context, videos
            ) {

            }
            rvVideoView.adapter = adapter
        }
    }

}