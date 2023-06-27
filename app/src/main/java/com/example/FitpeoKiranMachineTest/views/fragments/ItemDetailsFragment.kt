package com.example.FitpeoKiranMachineTest.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.FitpeoKiranMachineTest.R
import com.example.FitpeoKiranMachineTest.databinding.FragmentItemDetailsBinding
import com.example.FitpeoKiranMachineTest.viewmodels.MainViewModel
import com.example.FitpeoKiranMachineTest.views.MainActivity
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemDetailsFragment : Fragment(R.layout.fragment_item_details) {
    private lateinit var viewModel: MainViewModel
    private lateinit var context: MainActivity
    private lateinit var binding: FragmentItemDetailsBinding
    private val args: ItemDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemDetailsBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel
        setupFragment()
    }

    private fun setupFragment() {
        val itemId = args.itemId
        Picasso.get()
            .load(viewModel.photosList.value?.get(itemId)?.url ?: "")
            .placeholder(R.drawable.image_placeholder)
            .error(R.drawable.image_error)
            .centerCrop()
            .fit()
            .into(binding.imageView)
        binding.title.text = viewModel.photosList.value?.get(itemId)?.title
    }
}