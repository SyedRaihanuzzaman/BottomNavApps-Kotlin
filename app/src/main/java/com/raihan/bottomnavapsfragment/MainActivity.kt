package com.raihan.bottomnavapsfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.raihan.bottomnavapsfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      // Assign fragment to Variable
        val homeFragment = Home()
        val personFragment = Person()
        val settingsFragment = Settings()

      // Set a fragment to Default that will show in front
        setCurrentFragment(homeFragment)

     // Set Navigation item selected Listener for get the navigation translation
        binding.bottomnav.setOnNavigationItemSelectedListener{
            // Used 'When' to get id by Condition
            when(it.itemId){
                R.id.home ->setCurrentFragment(homeFragment)
                R.id.person ->setCurrentFragment(personFragment)
                R.id.settings ->setCurrentFragment(settingsFragment)
            }
            true
        }
    }

   // Create a Method for set fragment and simplyfy the code for reassign fragment
      private fun setCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentlayout,fragment)
            commit()
        }

    }
}