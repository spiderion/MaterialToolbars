package com.image.best.developodroid.materialdesigncourse

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.image.best.developodroid.materialdesigncourse.R.id.*
import org.jetbrains.anko.toast

class StandaloneToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone_toolbar)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        /* toolbar.title = "Standalone Toolbar"
         toolbar.subtitle = "by ion"*/
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        toolbar.setLogo(R.mipmap.ic_launcher_round)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  // if the >21 api attribute is applied in the java file we need to check the version
            toolbar.elevation = 10f
        }


        //lets inflate the menu
        toolbar.inflateMenu(R.menu.menu_main)

        //set on menu click listener
        toolbar.setOnMenuItemClickListener {
            // now write the code the action will be taken when an item will be clicked

            when (it.itemId) {
                settings -> toast("this is where you change your ${it.title}")

                camera -> toast("this is where you take a picture ")

                help -> toast("this is where ask for ${it.title}")

                save -> toast("this is how you ${it.title}")

                download -> toast("download")

                mail -> toast("mail")
            }


            true
        }
    }
}
