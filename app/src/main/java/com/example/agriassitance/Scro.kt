package com.example.agriassitance

import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.github.rubensousa.floatingtoolbar.FloatingToolbar
import com.github.rubensousa.floatingtoolbar.FloatingToolbarMenuBuilder
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions
import kotlinx.android.synthetic.main.activity_scro.*

class Scro : AppCompatActivity() {
    lateinit var menu: Menu
    var position:Int = 0
    lateinit var texdis:TextView
    var detail: String? = null
    lateinit var floatingActionButton: FloatingActionButton
lateinit var mFloatingToolbar:FloatingToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scro)
        texdis = findViewById(R.id.textview8) as TextView
        val mToolbar = findViewById(R.id.toolbar) as Toolbar
        mFloatingToolbar = findViewById(R.id.floatingToolbar) as FloatingToolbar
        floatingActionButton = findViewById(R.id.fab) as FloatingActionButton
        setSupportActionBar(mToolbar)
        val mAppBarLayout = findViewById(R.id.app_bar) as AppBarLayout
        mAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = false
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange()
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true
                    showOption(R.id.action_info)
                } else if (isShow) {
                    isShow = false
                    hideOption(R.id.action_info)
                }
            }
        })

        mFloatingToolbar.attachFab(fab)

        mFloatingToolbar.setClickListener(object : FloatingToolbar.ItemClickListener {
            override fun onItemClick(item: MenuItem) {

                   when(item.itemId)
                   {

                       2131230777-> {

                           val options = FirebaseTranslatorOptions.Builder()
                               .setSourceLanguage(FirebaseTranslateLanguage.EN)
                               .setTargetLanguage(FirebaseTranslateLanguage.HI)
                               .build()
                           val englishGermanTranslator =
                               FirebaseNaturalLanguage.getInstance().getTranslator(options)
                           englishGermanTranslator.downloadModelIfNeeded()
                               .addOnSuccessListener {
                                   englishGermanTranslator.translate(detail.toString())
                                       .addOnSuccessListener { translatedText ->
                                           texdis.setText(translatedText.toString())
                                       }
                                       .addOnFailureListener { exception ->
                                           // Error.
                                           // ...
                                       }
                               }
                       }
                       2131230771->{
                           val options = FirebaseTranslatorOptions.Builder()
                               .setSourceLanguage(FirebaseTranslateLanguage.EN)
                               .setTargetLanguage(FirebaseTranslateLanguage.TE)
                               .build()
                           val englishGermanTranslator =
                               FirebaseNaturalLanguage.getInstance().getTranslator(options)
                           englishGermanTranslator.downloadModelIfNeeded()
                               .addOnSuccessListener {
                                   englishGermanTranslator.translate(detail.toString())
                                       .addOnSuccessListener { translatedText ->
                                           texdis.setText(translatedText.toString())
                                       }
                                       .addOnFailureListener { exception ->
                                           // Error.
                                           // ...
                                       }
                               }
                       }
                   }

            }
//2131230771   and 777
            override fun onItemLongClick(item: MenuItem) {

            }
        })
        val intent = intent
        var user:String? = intent.getStringExtra("k")


            detail = user
        texdis.setText(detail)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        hideOption(R.id.action_info)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        } else if (id == R.id.action_info) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun hideOption(id: Int) {
        val item = menu.findItem(id)
        item.isVisible = false
    }

    private fun showOption(id: Int) {
        val item = menu.findItem(id)
        item.isVisible = true
    }
}
