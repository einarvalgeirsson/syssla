package com.jayway.syssla

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.view.View
import android.view.Window
import com.jayway.syssla.model.Chore
import com.jayway.syssla.view.Colors
import com.vicpin.krealmextensions.save
import kotlinx.android.synthetic.main.create_chore_layout.*
import kotlinx.android.synthetic.main.fab_layout.*


class CreateChoreActivity: AppCompatActivity() {

    var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        removeStatusBar()
        setupTransition()

        setContentView(R.layout.create_chore_layout)
        color = resources.getColor(Colors().getRandomColor(), theme)
        setBackgroundColor(color)

        setupFab()
    }

    private fun setBackgroundColor(color: Int?) {
        if (color != null) create_chore_layout.setBackgroundColor(color)
    }

    private fun removeStatusBar() {
        // remove title
        val decorView = window.decorView
        // Hide the status bar.
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

    }

    private fun setupTransition() {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.enterTransition = Fade()
    }

    private fun setupFab() {
        fab.apply {
            setImageDrawable(getDrawable(R.drawable.ic_done_white_24px))
            setOnClickListener({
                when {
                    chore_title_input.text.isEmpty() -> chore_title_input.error = "Namnet på en syssla kan inte vara tomt"
                    chore_points_input.text.isEmpty() -> chore_points_input.error = "En syssla måste ha tillhörande poäng"
                    else -> {
                        val title = chore_title_input.text.toString()
                        val points = chore_points_input.text.toString().toInt()
                        Chore(title = title, points = points, color = color!!).save()
                        goBackToMain()
                    }
                }
            })
        }
    }

    private fun goBackToMain()  {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}