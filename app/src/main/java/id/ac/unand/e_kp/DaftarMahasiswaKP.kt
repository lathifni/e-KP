package id.ac.unand.e_kp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import id.ac.unand.e_kp.databinding.ActivityDaftarKpMahasiswaBinding

class DaftarMahasiswaKP : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityDaftarKpMahasiswaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_daftar_kp_mahasiswa)

        binding = ActivityDaftarKpMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar1)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun ke_seminar(view: View) {
        val intent = Intent(this@DaftarMahasiswaKP, DetailSeminarKP::class.java)
        startActivity(intent)
    }

    fun ke_persetujuannilai(view: View) {
        val intent = Intent(this@DaftarMahasiswaKP, PersetujuanNilaiKP::class.java)
        startActivity(intent)
    }
}