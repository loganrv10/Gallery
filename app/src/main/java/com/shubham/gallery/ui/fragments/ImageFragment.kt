package com.shubham.gallery.ui.fragments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.shubham.gallery.R
import com.shubham.gallery.databinding.FragmentImageBinding
import com.shubham.gallery.extras.Constants.REQUEST_CODE
import com.shubham.gallery.ui.activities.DisplayActivity
import com.shubham.gallery.ui.adapter.GalleryAdapter
import com.shubham.gallery.viewmodels.ImageGalleryViewModel

class ImageFragment : Fragment() {

    private lateinit var imageFragmentImageBinding: FragmentImageBinding
    private var images = listOf<String>()
    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        imageFragmentImageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image, container, false)
        return imageFragmentImageBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Storage Permissions
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_CODE
            )
        } else {
            loadImages()
        }
    }

    private fun loadImages() {
        images = ImageGalleryViewModel.listOfImages(context)
        imageFragmentImageBinding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            adapter = GalleryAdapter(
                context, images
            ) {
                val intent = Intent(requireActivity(), DisplayActivity::class.java)
                intent.putExtra("path", it)
                startActivity(intent)

            }
            recyclerView.adapter = adapter
        }
    }
}

