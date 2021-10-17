package com.bottomnavigation.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bottomnavigation.test.fragments.FavoriteFragment
import com.bottomnavigation.test.fragments.HomeFragment
import com.bottomnavigation.test.fragments.SettingsFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    lateinit var bottom_navigation: ChipNavigationBar
    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)

        bottom_navigation = findViewById(R.id.bottom_navigation)
        bottom_navigation.setOnItemSelectedListener { id->
            when(id){
                R.id.home -> replaceFragment(homeFragment)
                R.id.favorites -> replaceFragment(favoriteFragment)
                R.id.settings -> replaceFragment(settingsFragment)
            }
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
          val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}