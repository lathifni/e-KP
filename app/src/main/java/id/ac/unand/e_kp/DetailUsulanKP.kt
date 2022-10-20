package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import id.ac.unand.e_kp.databinding.ActivityDetailUsulanKpBinding

class DetailUsulanKP : AppCompatActivity() {
    lateinit var binding: ActivityDetailUsulanKpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val bundle : Bundle? = intent.extras
        val nama = bundle!!.getString("nama")
        val nim = bundle!!.getString("nim")

        binding.headingNamaDetailUsulan.text = "Nama    : " + nama
        binding.headingNimDetailUsulan.text = "NIM        : " + nim

        binding.button5.setOnClickListener {
            Toast.makeText(this, "Diterima !!! ", Toast.LENGTH_SHORT).show()
        }

        binding.button6.setOnClickListener {
            Toast.makeText(this, "Ditolak !!! ", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}