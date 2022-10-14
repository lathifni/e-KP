package id.ac.unand.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.databinding.ActivityKonfirmasiBatalKpBinding
import id.ac.unand.e_kp.databinding.ActivityLogbookKpBinding
import java.util.ArrayList

class LogbookKP : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityLogbookKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<NamaMhs>
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_logbook_kp)

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

        mhsList = ArrayList()

        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Mendiskusikan project", "20/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Meeting", "21/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Mendiskusikan project", "20/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Meeting", "21/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Mendiskusikan project", "20/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Meeting", "21/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Mendiskusikan project", "20/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Meeting", "21/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Mendiskusikan project", "20/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Meeting", "21/09/2022"))
        mhsList.add(NamaMhs(R.drawable.ic_logbook, "Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))

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
//        recyclerView = findViewById(R.id.recycler_view6)
//
//        var data = ArrayList<NamaMhs>()
//        data.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523004"))
//        data.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523005"))
//        data.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523006"))
//        data.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523007"))
//        data.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523008"))
//
//        adapter = MyAdapter(data)
//    }
}