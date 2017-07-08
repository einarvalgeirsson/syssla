package com.jayway.syssla

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity


class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            kotlin.run {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }, 5000)
    }
}