package com.jayway.syssla.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View


open class NoStatusBarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        removeStatusBar()
    }

    private fun removeStatusBar() {
        // remove title
        val decorView = window.decorView
        // hide the status bar.
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions
    }
}