package com.example.colorsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colorsapp.ParentFragment.Companion.BLUE
import com.example.colorsapp.ParentFragment.Companion.GREEN
import com.example.colorsapp.ParentFragment.Companion.RED

class ColorViewModel: ViewModel() {
    private val _color = MutableLiveData<String>()
    val color: LiveData<String> = _color

    fun setColor (p1: Int, key: String) {
        when (key){
            RED -> setRedColor(p1)
            GREEN -> setGreenColor(p1)
            BLUE -> setBlueColor(p1)
        }
    }

    private fun convertProgress (p1: Int): String {
        var progress = Integer.toHexString(p1).uppercase()
        if (progress.length < 2) {
            progress = "0$progress"
        }
        return progress
    }

    private fun setRedColor(p1: Int) {
        val progress = convertProgress(p1)
        val color = "#${progress}0000"
        _color.value = color
    }

    private fun setGreenColor(p1: Int) {
        val progress = convertProgress(p1)
        val color = "#00${progress}00"
        _color.value = color
    }

    private fun setBlueColor(p1: Int) {
        val progress = convertProgress(p1)
        val color = "#0000${progress}"
        _color.value = color
    }
}