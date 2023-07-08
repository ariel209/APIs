package com.itsm.apis.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itsm.apis.R
import com.itsm.apis.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_cont) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = binding.nav
        navView.setupWithNavController(navController)
    }
}