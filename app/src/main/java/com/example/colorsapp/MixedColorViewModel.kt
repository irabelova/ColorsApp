package com.example.colorsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MixedColorViewModel : ViewModel() {
    private val _mixedColor = MediatorLiveData<String>()
    val mixedColor: LiveData<String> = _mixedColor

    private val _redColor = MutableLiveData("#000000")
    private val redColor: LiveData<String> = _redColor

    private val _blueColor = MutableLiveData("#000000")
    private val blueColor: LiveData<String> = _blueColor

    private val _greenColor = MutableLiveData("#000000")
    private val greenColor: LiveData<String> = _greenColor

    init {
        _mixedColor.addSource(redColor) {
            setMixedColor()
        }
        _mixedColor.addSource(greenColor) {
            setMixedColor()
        }
        _mixedColor.addSource(blueColor) {
            setMixedColor()
        }
    }

    fun setRedColor (redColor: String) {
        _redColor.value = redColor
    }
    fun setGreenColor (greenColor: String) {
        _greenColor.value = greenColor
    }
    fun setBlueColor (blueColor: String) {
        _blueColor.value = blueColor
    }

    private fun setMixedColor() {
        _mixedColor.value = "#${_redColor.value?.get(1)}" +
                "${_redColor.value?.get(2)}" +
                "${_greenColor.value?.get(3)}" +
                "${_greenColor.value?.get(4)}" +
                "${_blueColor.value?.get(5)}" +
                "${_blueColor.value?.get(6)}"
    }


}