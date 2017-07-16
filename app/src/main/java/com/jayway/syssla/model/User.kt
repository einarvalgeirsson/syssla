package com.jayway.syssla.model

import io.realm.RealmObject

open class User(): RealmObject() {

    var name = ""
    var id: String? = null

    constructor(name: String, id: String): this() {
        this.name = name
        this.id = id
    }
}