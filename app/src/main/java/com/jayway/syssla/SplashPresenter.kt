package com.jayway.syssla

import com.jayway.syssla.db.Db

class SplashPresenter() {

    fun userExists(db: Db): Boolean {
        val user = db.getUser()
        return user != null
    }
}