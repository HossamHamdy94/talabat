package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.waiting -> {
                println("watting  pressed")
                replaceFragment(Watingfregment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.accepted -> {
                println("accepted pressed")
                replaceFragment(Accepted())
                return@OnNavigationItemSelectedListener true
            }
            R.id.canceld -> {
                println("canceled pressed")
                replaceFragment(CanceledFragment())
                return@OnNavigationItemSelectedListener true
            }
        }

        false

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(Accepted())
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }


//    private fun loadFragment(fragment: Fragment) {
//        // load fragment
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}