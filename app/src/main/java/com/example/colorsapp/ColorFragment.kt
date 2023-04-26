package com.example.colorsapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.colorsapp.databinding.ColorFragmentBinding


class ColorFragment: Fragment() {
    private lateinit var binding: ColorFragmentBinding
    private val viewModel: ColorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ColorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val key = requireArguments().getString(COLOR_KEY)!!
        viewModel.color.observe(viewLifecycleOwner) {
            binding.colorImage.setBackgroundColor(Color.parseColor(it))
            setFragmentResult(key, bundleOf(KEY to it))
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.setColor(p1, key)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
    companion object {
        const val KEY = "KEY"
        private const val COLOR_KEY = "COLOR_KEY"
        fun newInstance(request: String): ColorFragment {
            val colorFragment = ColorFragment()
            colorFragment.arguments = bundleOf(
                COLOR_KEY to request
            )
            return colorFragment
        }
    }
}
