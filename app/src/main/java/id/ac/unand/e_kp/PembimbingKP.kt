package id.ac.unand.e_kp

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.adapter.DosenPengampuAdapter
import id.ac.unand.e_kp.databinding.ActivityPembimbingKpBinding
import id.ac.unand.e_kp.models.DosenPengampu


class PembimbingKP : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DosenPengampuAdapter
    private lateinit var dosenList : ArrayList<DosenPengampu>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityPembimbingKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.RV_radioPembimbing)
        recyclerView.layoutManager = LinearLayoutManager(this)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val bundle : Bundle? = intent.extras
        val nama = bundle?.getString("nama")
        val nim = bundle?.getString("nim")

        binding.textView7.text = nama
        binding.textView8.text = nim

        dosenList = ArrayList()
        dosenList.add(DosenPengampu("Husnil Kamil, MT", false))
        dosenList.add(DosenPengampu("Ricky Akbar, M.Kom", false))
        dosenList.add(DosenPengampu("Prof. Surya Afnarius", false))
        dosenList.add(DosenPengampu("Fajril Akbar, MT", false))

        adapter = DosenPengampuAdapter(dosenList)
        recyclerView.adapter = adapter

        binding.simpanPembimbing.isEnabled = false
        adapter.setOnItemClickListener(object : DosenPengampuAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                binding.simpanPembimbing.isEnabled = true
                binding.simpanPembimbing.setOnClickListener {
                    Toast.makeText(this@PembimbingKP, "Anda Berhasil Memilih "+dosenList[position].nama, Toast.LENGTH_SHORT).show()
                    binding.textView9.text = dosenList[position].nama
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}