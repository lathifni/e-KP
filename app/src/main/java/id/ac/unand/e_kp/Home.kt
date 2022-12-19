package id.ac.unand.e_kp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import id.ac.unand.e_kp.databinding.ActivityHomeBinding
import id.ac.unand.e_kp.response.LogoutResponse
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarHome.toolbar)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_logbook,
                R.id.nav_daftar_instansi,
                R.id.nav_selesai_kp,
                R.id.nav_selesai_kp
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val sharedPref =
            applicationContext.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN : ", token)

        }

        btnLogout.setOnClickListener {
            val retrofitClient = RetrofitClient.create()
            val callData = retrofitClient.logout("Bearer $token")
            callData.enqueue(object : Callback<LogoutResponse> {
                override fun onResponse(
                    call: Call<LogoutResponse>,
                    response: Response<LogoutResponse>
                ) {
                    Log.d("LOGOUTTT : ", response.body().toString())
                    with(sharedPref.edit()) {
                        clear()
                        apply()
                    }
                    intent = Intent(this@Home, Login::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                    Toast.makeText(this@Home, "Gaga", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun ke_login(view: View) {

//        intent = Intent(this, Login::class.java)
//        startActivity(intent)
    }
}