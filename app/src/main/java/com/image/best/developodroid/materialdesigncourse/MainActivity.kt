package com.image.best.developodroid.materialdesigncourse

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        // Check if we are running on Android 5.0 or higher
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //Call some material disign APIs here
        } else {// For Below API 21
            // Implement this feature without material design
        }

    }

    private fun init() {
        standoaloneBtn.setOnClickListener{startActivity<StandaloneToolbarActivity>()}
        contextualMenuBtn.setOnClickListener{startActivity<ContextualToolbarActivity>()}
        toolbarAsActionBar.setOnClickListener{startActivity<ActionBarActivity>()}
    }
}
