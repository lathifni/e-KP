package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.TugasBesarDzul.Adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.ActivityDetailSeminarKpBinding
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class DetailSeminarKP : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityDetailSeminarKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<Mahasiswa>
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSeminarKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val bundle : Bundle? = intent.extras
        val nama = bundle!!.getString("nama")
        val nim = bundle!!.getString("nim")

        binding.headingNamaDetailUsulan.text ="Nama     : " + nama
        binding.headingNimDetailUsulan.text = "NIM        : " + nim

        recyclerView = findViewById(R.id.recycler_view5)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mhsList = ArrayList()
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011522001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011522001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011522001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011522001"))

        adapter = MahasiswaAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}