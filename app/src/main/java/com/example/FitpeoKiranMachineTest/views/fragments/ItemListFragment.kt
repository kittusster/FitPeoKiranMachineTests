package com.example.FitpeoKiranMachineTest.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.FitpeoKiranMachineTest.Constants.TAG
import com.example.FitpeoKiranMachineTest.R
import com.example.FitpeoKiranMachineTest.adapters.ItemListAdapter
import com.example.FitpeoKiranMachineTest.databinding.FragmentItemListBinding
import com.example.FitpeoKiranMachineTest.viewmodels.MainViewModel
import com.example.FitpeoKiranMachineTest.views.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListFragment : Fragment(R.layout.fragment_item_list) {
    private lateinit var viewModel: MainViewModel
    private lateinit var context: MainActivity
    private lateinit var binding: FragmentItemListBinding
    private lateinit var itemListAdapter: ItemListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemListBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel
        setupFragment()
    }

    private fun setupFragment() {
        itemListAdapter = ItemListAdapter(arrayListOf()) {
            Log.d(TAG, "Selected item ID $it")
            it?.let { id-> findNavController().navigate(
                ItemListFragmentDirections.actionItemListFragmentToItemDetailsFragment(id)
            ) }

        }
        binding.itemList.adapter = itemListAdapter
        binding.itemList.layoutManager = LinearLayoutManager(requireContext())
        viewModel.photosList.observe(context){
            itemListAdapter.updatePhotoList(it)
        }
    }
}