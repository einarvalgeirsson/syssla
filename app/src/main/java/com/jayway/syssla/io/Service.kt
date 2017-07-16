package com.jayway.syssla.io

import com.jayway.syssla.model.User

interface Service {
    fun getUserById(id: String): User
}