package com.jayway.syssla

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_partner_layout.*


class RegisterPartnerActivity: AppCompatActivity() {

    lateinit var presenter: RegisterUserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_partner_layout)
        presenter = RegisterUserPresenter()


        partner_name_button.setOnClickListener({
            val selectedPartnerName = partner_name.text.toString()
            if (presenter.isUsernameValid(selectedPartnerName, this::setErrorMsg)) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        })
    }

    fun setErrorMsg(errorMsg: String)  {
        partner_name_button.error = errorMsg
    }
}