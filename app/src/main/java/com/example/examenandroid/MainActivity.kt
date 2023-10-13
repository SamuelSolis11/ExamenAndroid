package com.example.examenandroid

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.examenandroid.databinding.ActivityMainBinding
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val a1 = Auto("1","Ferrari x",50000.55, "rojo", "De Gas" , "Si")
        val a2 = Auto("2","Aveo ",20000.55, "Blanco", "De Gas" , "No")
        val a3 = Auto("3","Tesla ",120000.55, "Azul", "Electrico" , "No")
        val a4 = Auto("4","Lamborguini x",1230000.55, "Negro", "De Gas" , "No")
        val a5 = Auto("5","Nissan Force",10000.55, "Gris", "Electrico" , "Si")
        val a6 = Auto("6","Chevrolet ",30000.55, "verde", "Electrico" , "No")
        Singleton.lista.add(a1)
        Singleton.lista.add(a2)
        Singleton.lista.add(a3)
        Singleton.lista.add(a4)
        Singleton.lista.add(a5)
        Singleton.lista.add(a6)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}