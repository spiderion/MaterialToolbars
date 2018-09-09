package com.image.best.developodroid.materialdesigncourse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.image.best.developodroid.materialdesigncourse.R.id.*
import org.jetbrains.anko.toast

class ActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar) // using the toolbar as action bar
        supportActionBar?.title = "Action Bar Toolbar "
        supportActionBar?.subtitle = "by ion "

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main,menu)  // notice difference against  toolbar.inflateMenu(R.menu.menu_main) set in the normal toolbar
        return true // if return is false it will not inflate the menu

        // now the overflow menu is clickable but not the items ... for the items we need to override the onOptionItemSelected
    }

     override fun onOptionsItemSelected(item: MenuItem?): Boolean { // notice difference against toolbar.setOnMenuItemClickListener in the normal toolbar


         var string = ""
         when(item?.itemId){
             settings -> string = "you clicked on settings"
             help -> string = "you clicked on help"
             camera -> string ="your camera is not working properly"
             download -> string ="download does not work "

         }
         toast(string)
        return super.onOptionsItemSelected(item)
    }
}
