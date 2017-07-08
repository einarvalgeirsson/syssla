package com.jayway.syssla

import android.util.Log
import com.jayway.syssla.view.getRandomColor
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var i = 0

        while (i < 10) {
            val c = getRandomColor()
            i++
        }
    }
}
