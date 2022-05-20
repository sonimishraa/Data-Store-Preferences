package com.example.datastorepreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import com.example.datastorepreferences.databinding.ActivityMainBinding
import com.example.datastorepreferences.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initObserver()
    }
    private fun initView() {
        binding.setButton.setOnClickListener {
            viewModel.setPrefData(binding.etvName.text.toString())
        }
        binding.getButton.setOnClickListener {
            viewModel.get()
        }
    }

    private fun initObserver() {
       viewModel.name_response.observe(this) {
         it?.let {
             //Log.i("TVText",binding.etvName.text.toString())
               binding.tvName.setText(it)
           }
       }
    }
}