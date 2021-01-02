package com.dynamicdudes.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dynamicdudes.homescreen.databinding.ActivityMainBinding
import com.dynamicdudes.homescreen.fragments.HomeFragment
import com.dynamicdudes.homescreen.fragments.PostFragment
import com.dynamicdudes.homescreen.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val postFragment = PostFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_post -> makeCurrentFragment(postFragment)
                R.id.ic_user -> makeCurrentFragment(profileFragment)
            }
            true
        }


    }

    private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper,fragment)
                commit()
            }
}