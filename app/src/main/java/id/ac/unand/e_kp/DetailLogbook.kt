package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import id.ac.unand.e_kp.databinding.ActivityDaftarKpMahasiswaBinding
import id.ac.unand.e_kp.databinding.ActivityDetailLogbookBinding

class DetailLogbook : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityDetailLogbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar6)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

//        setContentView(R.layout.activity_detail_logbook)

        val bundle : Bundle? = intent.extras
        val kegiatan = bundle!!.getString("kegiatan")
        val tanggal = bundle!!.getString("tanggal")

        binding.textView37.text = kegiatan
        binding.textView40.text = kegiatan
        binding.textView42.text = tanggal
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}