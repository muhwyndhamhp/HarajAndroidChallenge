package com.example.harajtask.feature

import android.os.Bundle
import com.example.harajtask.databinding.ActivityMainBinding
import com.example.harajtask.essential.base.BaseActivity

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}