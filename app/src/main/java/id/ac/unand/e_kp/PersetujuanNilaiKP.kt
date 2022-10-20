package id.ac.unand.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.databinding.ActivityDetailSeminarKpBinding
import id.ac.unand.e_kp.databinding.ActivityPersetujuanNilaiKpBinding
import java.util.ArrayList

class PersetujuanNilaiKP : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityPersetujuanNilaiKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<NamaMhs>
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersetujuanNilaiKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar3)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view7)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mhsList = ArrayList()

        mhsList.add(NamaMhs(R.drawable.ic_persetujuan, "nilai 1", "20/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_persetujuan, "nilai 2", "21/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_persetujuan, "nilai 3", "22/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_persetujuan, "nilai 4", "20/09/2022"))

        adapter = MyAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}