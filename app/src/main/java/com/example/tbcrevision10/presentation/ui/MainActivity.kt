package com.example.tbcrevision10.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbcrevision10.data.common.ResponseHandler
import com.example.tbcrevision10.databinding.ActivityMainBinding
import com.example.tbcrevision10.presentation.adapters.MessageAdapters
import com.example.tbcrevision10.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private val messageAdapters= MessageAdapters()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer()
        setUpRecycler()
    }

    private fun observer() {
        lifecycleScope.launch {
            mainViewModel.messageFlow.collect {
                if (it is ResponseHandler.Success) {
                    messageAdapters.submitList(it.response)
                }
            }
        }
    }

    private fun setUpRecycler() {

        binding.rv.apply {
            adapter = messageAdapters
            layoutManager = GridLayoutManager(this@MainActivity, 1)
        }
        lifecycleScope.launch {
            mainViewModel.getMessages()
        }
    }
}