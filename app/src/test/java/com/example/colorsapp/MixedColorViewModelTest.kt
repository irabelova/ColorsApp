package com.example.colorsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase
import org.junit.Test
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MixedColorViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun set_red_color_test() {
        val viewModel = MixedColorViewModel()
        viewModel.mixedColor.observeForever { }
        viewModel.setRedColor("#450000")
        TestCase.assertEquals("#450000", viewModel.mixedColor.value)
    }

    @Test
    fun set_green_color_test() {
        val viewModel = MixedColorViewModel()
        viewModel.mixedColor.observeForever { }
        viewModel.setGreenColor("#00A700")
        TestCase.assertEquals("#00A700", viewModel.mixedColor.value)
    }

    @Test
    fun set_blue_color_test() {
        val viewModel = MixedColorViewModel()
        viewModel.mixedColor.observeForever { }
        viewModel.setBlueColor("#0000F2")
        TestCase.assertEquals("#0000F2", viewModel.mixedColor.value)
    }

    @Test
    fun set_all_colors_test() {
        val viewModel = MixedColorViewModel()
        viewModel.mixedColor.observeForever { }
        viewModel.setRedColor("#450000")
        viewModel.setBlueColor("#0000F2")
        viewModel.setGreenColor("#00A700")
        TestCase.assertEquals("#45A7F2", viewModel.mixedColor.value)
    }
}