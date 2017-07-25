package com.jayway.syssla

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import io.realm.Realm
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class SplashActivity: AppCompatActivity() {

    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)
        Realm.init(applicationContext)

        presenter = SplashPresenter()
        updateKeyHash()
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            kotlin.run {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }, 2000)
    }

    fun updateKeyHash() {
        try {
            val info = packageManager.getPackageInfo(
                    "com.jayway.syssla",
                    PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {

        } catch (e: NoSuchAlgorithmException) {

        }
    }
}