package com.example.arbuz.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.arbuz.R
import com.example.arbuz.databinding.ActivityMainBinding
import com.example.arbuz.fragment.CartFragment
import com.example.arbuz.fragment.PhotosFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the initial fragment
        if (savedInstanceState == null) {
            replaceFragment(PhotosFragment())
        }

        // Set up the BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(PhotosFragment())
                R.id.profile -> replaceFragment(CartFragment())
                else -> false
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .addToBackStack(null) // Optional: Add transaction to back stack
            .commit()
    }
}
