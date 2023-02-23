package com.giulioaterno.becomechef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.giulioaterno.becomechef.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            setBottomBarClick(it)
        }
        replaceFragment(HomeScreenFragment())

}

    private fun setBottomBarClick(it: MenuItem): Boolean {
        when (it.itemId) {
            R.id.home -> replaceFragment(HomeScreenFragment())
            R.id.myFridge -> replaceFragment(MyFridgeFragment())
            R.id.recipes -> replaceFragment(RecipesFragment())
            R.id.settings -> replaceFragment(SettingsFragment())
            R.id.profile -> replaceFragment(ProfilePageFragment())
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bottomNavigationView, fragment)
        fragmentTransaction.commit()
    }
}