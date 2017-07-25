package com.jayway.syssla.facebook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.facebook.*
import com.facebook.login.LoginResult
import com.jayway.syssla.R
import com.jayway.syssla.view.NoStatusBarActivity
import kotlinx.android.synthetic.main.fb_login_activity.*


class FacebookLoginActivity: NoStatusBarActivity() {

    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fb_login_activity)

        callbackManager = CallbackManager.Factory.create()
        userPic.isCropped = true

        setupLoginButton()
    }

    fun setupLoginButton() {
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // App code
                Toast.makeText(
                        applicationContext,
                        "SUCCESS",
                        Toast.LENGTH_LONG).show()
                updateUI()
            }

            override fun onCancel() {
                // App code
                Toast.makeText(
                        applicationContext,
                        "CANCEL",
                        Toast.LENGTH_LONG).show()
            }

            override fun onError(exception: FacebookException) {
                // App code
                Toast.makeText(
                        applicationContext,
                        "ERROR",
                        Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateUI() {
        val profile = Profile.getCurrentProfile()
        if (profile != null) {
            userPic.profileId = profile.id
            userName.text = String.format("%s %s", profile.firstName, profile.lastName)
        } else {
            userPic.profileId = null
            userName.text = getString(R.string.welcome)
        }
    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}