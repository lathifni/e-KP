package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.unand.e_kp.databinding.ActivityDetailUsulanKpBinding

class DetailUsulanKP : AppCompatActivity() {
    lateinit var binding: ActivityDetailUsulanKpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}