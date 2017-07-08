package com.jayway.syssla.view

import com.jayway.syssla.R

class Colors {

    val colors = listOf<Int>(
            R.color.pink,
            R.color.purple,
            R.color.deepPurple,
            R.color.indigo,
            R.color.blue,
            R.color.green,
            R.color.cyan,
            R.color.lightblue,
            R.color.lightGreen,
            R.color.blueGrey,
            R.color.teal,
            R.color.orange,
            R.color.deepOrange,
            R.color.amber,
            R.color.brown,
            R.color.red
    )

    fun getRandomColor(): Int {
        return colors[(Math.random() * colors.size - 1).toInt()]
    }
}
