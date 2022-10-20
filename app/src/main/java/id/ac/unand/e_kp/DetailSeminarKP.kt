package id.ac.unand.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.databinding.ActivityDaftarKpMahasiswaBinding
import id.ac.unand.e_kp.databinding.ActivityDetailSeminarKpBinding
import java.util.ArrayList

class DetailSeminarKP : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityDetailSeminarKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<NamaMhs>
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_seminar_kp)

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

        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011522001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011522001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011522001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011522001"))

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

//    private fun init(){
//        recyclerView = findViewById(R.id.recycler_view5)
//
//        var data = ArrayList<NamaMhs>()
//        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))
//        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523005"))
//        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523006"))
//        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523007"))
//        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523008"))
//
//        adapter = MyAdapter(data)
//    }
}