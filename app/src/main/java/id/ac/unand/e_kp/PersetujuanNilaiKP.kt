package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.adapter.PersetujuanNilaiAdapter
import id.ac.unand.e_kp.databinding.ActivityPersetujuanNilaiKpBinding
import id.ac.unand.e_kp.models.PersetujuaanNilai
import java.util.ArrayList

class PersetujuanNilaiKP : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var recyclerView: RecyclerView
    private lateinit var nilaiList: ArrayList<PersetujuaanNilai>
    private lateinit var adapter: PersetujuanNilaiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityPersetujuanNilaiKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.persetujuan_nilai)
        setSupportActionBar(binding.toolbar3)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val bundle: Bundle? = intent.extras
        val nama = bundle?.getString("nama")
        val nim = bundle?.getString("nim")

        binding.textView18.text = nama
        binding.textView19.text = nim

        nilaiList = ArrayList()

        nilaiList.add(PersetujuaanNilai("nilai 1", false))
        nilaiList.add(PersetujuaanNilai("nilai 2", false))
        nilaiList.add(PersetujuaanNilai("nilai 3", false))
        nilaiList.add(PersetujuaanNilai("nilai 4", false))
        nilaiList.add(PersetujuaanNilai("nilai 5", false))
        nilaiList.add(PersetujuaanNilai("nilai 6", false))
        nilaiList.add(PersetujuaanNilai("nilai 7", false))


        adapter = PersetujuanNilaiAdapter(nilaiList)
        recyclerView.adapter = adapter

        binding.button13.isEnabled = false
        adapter.setOnItemClickListener(object : PersetujuanNilaiAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                binding.button13.isEnabled = true
                binding.button13.setOnClickListener {
                    Toast.makeText(this@PersetujuanNilaiKP, "Nilai Disetujui", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}