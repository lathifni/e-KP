package id.ac.unand.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // inisialisasi view
        val decorView = window.decorView
        // Hide the status bar.
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        if (supportActionBar != null){
            supportActionBar!!.hide()
        }
    }

    fun ke_home(view: View) {
        intent = Intent(this, Home::class.java)
        startActivity(intent)
    }
}