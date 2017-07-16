package com.jayway.syssla

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.jayway.syssla.db.DbImpl
import io.realm.Realm

class SplashActivity: AppCompatActivity() {

    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)
        Realm.init(applicationContext)

        presenter = SplashPresenter()
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            kotlin.run {
                if (presenter.userExists(DbImpl())) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    startActivity(Intent(this, RegisterUserActivity::class.java))
                }
            }
        }, 2000)
    }
}