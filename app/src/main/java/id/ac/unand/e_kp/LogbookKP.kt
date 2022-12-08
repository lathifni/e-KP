package id.ac.unand.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.adapter.LogbookAdapter
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.ActivityKonfirmasiBatalKpBinding
import id.ac.unand.e_kp.databinding.ActivityLogbookKpBinding
import id.ac.unand.e_kp.databinding.FragmentLogbookHarianBinding
import id.ac.unand.e_kp.models.Logbook
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class LogbookKP : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityLogbookKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsLogbook: ArrayList<Logbook>
    private lateinit var adapter: LogbookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogbookKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar5)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view6)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val bundle : Bundle? = intent.extras
        val nama = bundle!!.getString("nama")
        val nim = bundle!!.getString("nim")

        binding.textView15.text = nama
        binding.textView16.text = nim

        mhsLogbook = ArrayList()
        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))


        adapter = LogbookAdapter(mhsLogbook)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : LogbookAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@LogbookKP, DetailLogbook::class.java)
                intent.putExtra("kegiatan", mhsLogbook[position].kegiatan)
                intent.putExtra("tanggal", mhsLogbook[position].tanggal)
                startActivity(intent)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}