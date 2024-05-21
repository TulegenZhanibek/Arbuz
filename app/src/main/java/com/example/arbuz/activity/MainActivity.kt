package com.example.arbuz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arbuz.R
import com.example.arbuz.fragment.PhotosFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, PhotosFragment())
            .commit()
    }
}