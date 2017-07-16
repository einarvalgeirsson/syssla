package com.jayway.syssla.db

import com.jayway.syssla.model.Chore
import com.jayway.syssla.model.User
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.queryFirst
import com.vicpin.krealmextensions.save
import io.realm.exceptions.RealmMigrationNeededException

class DbImpl: Db {

    override fun getUser(): User? {
        var user: User?
        try {
            user = User().queryFirst()
        } catch (e: RealmMigrationNeededException) {
            // there is no schema for user at all
            user = null
        }
        return user
    }

    override fun storeUser(user: User) {
        user.save()
    }

    override fun storeChore(chore: Chore) {
        chore.save()
    }

    override fun getChores(): List<Chore> {
        return Chore().queryAll()
    }
}