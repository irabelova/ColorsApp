package com.example.colorsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.colorsapp.ColorFragment.Companion.KEY
import com.example.colorsapp.databinding.ParentFragmentBinding

class ParentFragment: Fragment() {
    private lateinit var binding: ParentFragmentBinding
    private val viewModel: MixedColorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ParentFragmentBinding.inflate(inflater, container, false)
        childFragmentManager.beginTransaction()
            .replace(R.id.container_mix_color, MixedColorFragment.newInstance())
            .commit()
        childFragmentManager.beginTransaction()
            .replace(R.id.container_red_color, ColorFragment.newInstance(RED))
            .commit()
        childFragmentManager.beginTransaction()
            .replace(R.id.container_blue_color, ColorFragment.newInstance(BLUE))
            .commit()
        childFragmentManager.beginTransaction()
            .replace(R.id.container_green_color, ColorFragment.newInstance(GREEN))
            .commit()
        childFragmentManager.setFragmentResultListener(
            RED, viewLifecycleOwner
        ) { _, bundle ->
            val color = bundle.getString(KEY)
            if (color != null) {
                viewModel.setRedColor(color)
            }
        }
        childFragmentManager.setFragmentResultListener(
            GREEN, viewLifecycleOwner
        ) { _, bundle ->
            val color = bundle.getString(KEY)
            if (color != null) {
                viewModel.setGreenColor(color)
            }
        }
        childFragmentManager.setFragmentResultListener(
            BLUE, viewLifecycleOwner
        ) { _, bundle ->
            val color = bundle.getString(KEY)
            if (color != null) {
                viewModel.setBlueColor(color)
            }
        }
        return binding.root
    }
    companion object {
        const val RED = "RED"
        const val BLUE = "BLUE"
        const val GREEN = "GREEN"
    }
}