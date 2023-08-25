package com.example.cricquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cricquiz.R
import com.example.cricquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolBar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolBar)
        val nav = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = nav.navController
        setupActionBarWithNavController(navController)



    }
//    private fun replaceFragment(fragment : Fragment){
//        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,fragment).commit()
//    }
    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
              R.id.one -> Toast.makeText(this,"Option 1",Toast.LENGTH_SHORT).show()
              R.id.two -> Toast.makeText(this,"Option 2",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}