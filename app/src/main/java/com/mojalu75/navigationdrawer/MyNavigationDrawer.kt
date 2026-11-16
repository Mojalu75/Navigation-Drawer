package com.mojalu75.navigationdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MyNavigationDrawer : AppCompatActivity() {

    // Equivalente a private AppBarConfiguration mAppBarConfiguration;
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation_drawer)

        // toolbar es la barra horizontal superior en la que se encuentra la hamburguesa
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // drawer es el layout del activity que contiene el Navigation Drawer
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)

        // navigationView es el menú Navigation Drawer
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        // Pasamos los IDs de cada menú a la configuración del navigation drawer
        // En Kotlin se utiliza un setOf para agrupar los destinos principales
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawer
        )

        // nav_host_fragment es la id del fragmento que almacenará los contenidos
        val navController = findNavController(R.id.nav_host_fragment)

        // Vinculamos el navController con su configuración
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}