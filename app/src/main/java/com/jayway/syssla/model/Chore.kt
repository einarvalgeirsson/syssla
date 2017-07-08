package com.jayway.syssla.model

import io.realm.RealmObject

open class Chore(): RealmObject() {

    var title = ""
    var points = 0
    var color = 0

    constructor(title: String, points: Int, color: Int) : this() {
        this.title = title
        this.points = points
        this.color = color
    }
}
