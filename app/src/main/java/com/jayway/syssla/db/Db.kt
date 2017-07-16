package com.jayway.syssla.db

import com.jayway.syssla.model.Chore
import com.jayway.syssla.model.User

interface Db {
    fun getUser(): User?
    fun storeUser(user: User)
    fun storeChore(chore: Chore)
    fun getChores(): List<Chore>
}