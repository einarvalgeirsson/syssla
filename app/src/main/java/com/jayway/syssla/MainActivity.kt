package com.jayway.syssla

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Explode
import android.transition.Fade
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import com.jayway.syssla.model.Chore
import com.jayway.syssla.view.ChoresListAdapter
import com.vicpin.krealmextensions.queryAll
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_layout.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fab_layout.*
import android.view.Window.FEATURE_CONTENT_TRANSITIONS
import com.facebook.login.LoginManager
import com.vicpin.krealmextensions.deleteAll


class MainActivity : AppCompatActivity() {

    private var choresListAdapter: ChoresListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inside your activity (if you did not enable transitions in your theme)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        // set an exit transition
        window.exitTransition = Fade()
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.abs_layout)

        fab.setOnClickListener({
            intent = Intent(this, CreateChoreActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        })

        LoginManager.getInstance().logInWithPublishPermissions(this, listOf("publish_actions"))
        setupList()
    }


    fun setupList() {
        val recyclerView = recycler_view as RecyclerView
        recyclerView.setHasFixedSize(true);

        recyclerView.layoutManager = LinearLayoutManager(this)

        // specify an adapter (see also next example)
        choresListAdapter = ChoresListAdapter(Chore().queryAll());

        recyclerView.setAdapter(choresListAdapter);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
