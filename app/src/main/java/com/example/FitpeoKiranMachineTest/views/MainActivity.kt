package com.example.FitpeoKiranMachineTest.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.FitpeoKiranMachineTest.databinding.ActivityMainBinding
import com.example.FitpeoKiranMachineTest.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var waitDialog: WaitDialog
    private lateinit var binding: ActivityMainBinding
     val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        waitDialog = WaitDialog(this)

        setupActivity()
    }

    private fun setupActivity() {
        lifecycleScope.launchWhenCreated {
            viewModel.isLoading.collect { if (it) waitDialog.showDialog() else waitDialog.dismiss() }
        }
    }
}