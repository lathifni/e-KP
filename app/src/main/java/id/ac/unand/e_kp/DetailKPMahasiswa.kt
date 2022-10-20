package id.ac.unand.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.adapter.MahasiswaSelesaiAdapter
import id.ac.unand.e_kp.databinding.ActivityDetailKpmahasiswaBinding
import id.ac.unand.e_kp.databinding.ActivityUsulanKpBinding
import id.ac.unand.e_kp.databinding.FragmentLogbookHarianBinding
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class DetailKPMahasiswa : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDetailKpmahasiswaBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<Mahasiswa>
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKpmahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mhsList = ArrayList()

        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523009"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))

        adapter = MahasiswaAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DetailKPMahasiswa, DaftarMahasiswaKP::class.java)
                intent.putExtra("nama", mhsList[position].nama)
                intent.putExtra("nim", mhsList[position].nim)
                startActivity(intent)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}