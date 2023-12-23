package com.example.agriassitance

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.Auth
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer
import kotlinx.android.synthetic.main.nav_header.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener   {
    override fun onNavigationItemSelected(p0: android.view.MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_cultivation -> {
                Toast.makeText(this, "Cultivation clicked", Toast.LENGTH_SHORT).show()
                runnable = navigateLibrary
            }
            R.id .nav_diseases -> {
                runnable = dis
                Toast.makeText(this, "Diseases clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_medicines -> {
                runnable = med
                Toast.makeText(this, "Medicines clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_Government -> {
                runnable = gov
                Toast.makeText(this, "Government clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                AuthUI.getInstance().signOut(this@MainActivity).addOnCompleteListener {
//                    showsigninoptions()
                }.addOnFailureListener { e->Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_SHORT).show() }
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        if (runnable != null) {

            var handler = Handler()
            handler.postDelayed({ runnable!!.run() }, 350)
        }
        return true

    }




lateinit var imageView: ImageView
lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
lateinit var use:TextView
    lateinit var navView: NavigationView
    var runnable: Runnable? = null
    lateinit var providers: List<AuthUI.IdpConfig>
    val navigateLibrary = Runnable {
        var fragment1: Fragment = one()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout,fragment1).commitAllowingStateLoss()


    }
    val dis = Runnable {
        var fragment1: Fragment = dises()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout,fragment1).commitAllowingStateLoss()


    }
    val med = Runnable {
        var fragment1: Fragment = Medi()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout,fragment1).commitAllowingStateLoss()


    }
    val gov = Runnable {
        var fragment1: Fragment = Gov()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout,fragment1).commitAllowingStateLoss()


    }
    var navDrawerRunnable: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)



        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)


        providers = Arrays.asList(
            AuthUI.IdpConfig.EmailBuilder().build(),

            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()

        )
//        showsigninoptions()
        var user:FirebaseUser? = FirebaseAuth.getInstance().getCurrentUser()

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        val headerview = navView.getHeaderView(0)
 var lV:LinearLayout = headerview.findViewById(R.id.navhea)
        use  =   headerview.findViewById(R.id.user)  as TextView
        imageView =   headerview.findViewById(R.id.imageViewuser) as ImageView
        if (user != null) {


            var photoUrl: Uri? = user.getPhotoUrl()
            Glide.with(this).load(photoUrl).into(imageView)
            var uid:String = user.email.toString()
            use.text = uid
        }







    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 7117){
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode == Activity.RESULT_OK)
            {
                val user = FirebaseAuth.getInstance().currentUser
                Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()

            }
        }
    }
//    fun showsigninoptions()
//    {
//   startActivityForResult (AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).setTheme(R.style.MyTheme).build(),7117)
//
//
//    }
}
