package com.image.best.developodroid.materialdesigncourse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.image.best.developodroid.materialdesigncourse.R.id.help
import com.image.best.developodroid.materialdesigncourse.R.id.settings
import org.jetbrains.anko.appcompat.v7.coroutines.onMenuItemClick
import org.jetbrains.anko.sdk25.coroutines.onLongClick
import org.jetbrains.anko.toast

class ContextualToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contextual_toolbar)

        val contextualBtn = findViewById<Button>(R.id.contextualBtn)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) // if you don't have this id in the specific layout your toolbar will be null
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.onMenuItemClick {

            var string = ""

            when(it?.itemId){

                help -> string = "help"

                settings -> string = "settings"


            }
            toast(string)
        }

        contextualBtn.onLongClick {

            startSupportActionMode(object  : ActionMode.Callback{
                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    //when the button is clicked the menu will be inflated in the toolbar
                    mode?.menuInflater?.inflate(R.menu.contextual_menu,menu)

                   return true
                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    mode?.title = "actionmode"
                    mode?.subtitle = "by ion "
                    return true
                }

                override fun onActionItemClicked(mode: ActionMode?, menu: MenuItem?): Boolean {

                    contextualBtn.visibility = View.GONE
                    return false
                }

                override fun onDestroyActionMode(mode: ActionMode?) {
                    //noop
                }
            })
        }
    }


}


