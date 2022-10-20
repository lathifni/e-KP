package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.adapter.DosenPengampuAdapter
import id.ac.unand.e_kp.databinding.ActivityListInstansiBinding
import id.ac.unand.e_kp.models.DosenPengampu


class ListInstansi : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var instansiList : ArrayList<DosenPengampu>
    private lateinit var adapter: DosenPengampuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListInstansiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.RV_listInstansi)
        recyclerView.layoutManager = LinearLayoutManager(this)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val bundle : Bundle? = intent.extras
        val nama = bundle?.getString("nama")
        val nim = bundle?.getString("nim")

        binding.textView22.text = nama
        binding.textView24.text = nim

        instansiList = ArrayList()
        instansiList.add(DosenPengampu("PT Multipolar", false))
        instansiList.add(DosenPengampu("PT Telkom", false))
        instansiList.add(DosenPengampu("Menkominfo", false))
        instansiList.add(DosenPengampu("Mediatama", false))
        instansiList.add(DosenPengampu("PT Multipolar", false))

        adapter = DosenPengampuAdapter(instansiList)
        recyclerView.adapter = adapter

        binding.button12.isEnabled = false
        adapter.setOnItemClickListener(object : DosenPengampuAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                binding.button12.isEnabled = true
                binding.button12.setOnClickListener {
                    Toast.makeText(this@ListInstansi, "Anda Berhasil Memilih "+instansiList[position].nama, Toast.LENGTH_SHORT).show()
                    binding.textView25.text = instansiList[position].nama
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}