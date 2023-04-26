package com.example.colorsapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.colorsapp.databinding.MixedColorFragmentBinding

class MixedColorFragment : Fragment() {
    private lateinit var binding: MixedColorFragmentBinding
    private val viewModel: MixedColorViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MixedColorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.mixedColor.observe(viewLifecycleOwner) {
          binding.mixedColorImage.setBackgroundColor(Color.parseColor(it))
            binding.mixedColorText.text = it
        }
    }

    companion object {
        fun newInstance(): MixedColorFragment {
            return MixedColorFragment()
        }
    }
}
