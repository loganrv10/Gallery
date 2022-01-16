package com.shubham.gallery.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shubham.gallery.R
import com.shubham.gallery.databinding.ActivityDisplayBinding
import com.bumptech.glide.Glide

class DisplayActivity : AppCompatActivity() {

    private lateinit var displayBinding: ActivityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displayBinding = DataBindingUtil.setContentView(this, R.layout.activity_display)

        val imagePath = intent.getStringExtra("path")
        Glide.with(displayBinding.ivImage).load(imagePath).into(displayBinding.ivImage)
    }
}