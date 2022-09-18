package id.ac.unand.e_kp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // inisialisasi view
        val decorView = window.decorView
        // Hide the status bar.
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        if (supportActionBar != null){
            supportActionBar!!.hide()
        }
        Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 3500)
    }
}