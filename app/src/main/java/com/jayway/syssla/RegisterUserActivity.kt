package com.jayway.syssla

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jayway.syssla.db.DbImpl
import com.jayway.syssla.model.User
import kotlinx.android.synthetic.main.register_user_layout.*
import java.util.*

class RegisterUserActivity: AppCompatActivity() {

    lateinit var db: DbImpl
    lateinit var presenter: RegisterUserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_user_layout)
        db = DbImpl()
        presenter = RegisterUserPresenter()

        username_button.setOnClickListener({
            val selectedName = username.text.toString()
            if (presenter.isUsernameValid(selectedName, this::setErrorMsg)) {
                db.storeUser(User(selectedName
                        , UUID.randomUUID().toString()))
                // Need to check if user has partner
                startActivity(Intent(this, RegisterPartnerActivity::class.java))
            }
        })
    }

    private fun setErrorMsg(errorMsg: String) {
        username.error = errorMsg
    }


}