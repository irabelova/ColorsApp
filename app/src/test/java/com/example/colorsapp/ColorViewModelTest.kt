package com.example.colorsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.colorsapp.ParentFragment.Companion.BLUE
import com.example.colorsapp.ParentFragment.Companion.GREEN
import com.example.colorsapp.ParentFragment.Companion.RED
import junit.framework.TestCase
import org.junit.Test
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ColorViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Test
    fun set_red_color_test() {
        val viewModel = ColorViewModel()
        viewModel.color.observeForever {}
        viewModel.setColor(3, RED)
        TestCase.assertEquals("#030000", viewModel.color.value)
    }

    @Test
    fun set_green_color_test() {
        val viewModel = ColorViewModel()
        viewModel.color.observeForever {}
        viewModel.setColor(16, GREEN)
        TestCase.assertEquals("#001000", viewModel.color.value)
    }

    @Test
    fun set_blue_color_test() {
        val viewModel = ColorViewModel()
        viewModel.color.observeForever {}
        viewModel.setColor(7, BLUE)
        TestCase.assertEquals("#000007", viewModel.color.value)
    }
}