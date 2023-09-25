package com.raihan.bottomnavapsfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.raihan.bottomnavapsfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var actionBarDrawerToggle:ActionBarDrawerToggle
    val homeFragment = Home()
    val personFragment = Person()
    val settingsFragment = Settings()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Assign drawler layout to actionbardrawertoggle
        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.mydrawerlayout,R.string.nav_open,R.string.nav_close)

        binding.mydrawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



      // Set a fragment to Default that will show in front
        setCurrentFragment(homeFragment)

        binding.navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    setCurrentFragment(homeFragment)
                    //close drawer when we click new item
                    binding.mydrawerlayout.closeDrawers()
                }

                R.id.person ->{
                    setCurrentFragment(personFragment)
                    binding.mydrawerlayout.closeDrawers()
                }
                R.id.settings ->{
                    setCurrentFragment(settingsFragment)
                    binding.mydrawerlayout.closeDrawers()
                }
            }
            true
        }


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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }


   // Create a Method for set fragment and simplyfy the code for reassign fragment
   //create a method for set fragment and simplify the code for reassign
   private fun setCurrentFragment(fragment: Fragment){
       supportFragmentManager.beginTransaction().apply {
           replace(R.id.fragmentlayout, fragment)
           commit()
       }
   }

}