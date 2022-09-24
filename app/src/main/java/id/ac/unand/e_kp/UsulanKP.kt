package id.ac.unand.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.databinding.ActivityUsulanKpBinding
import java.util.ArrayList

class UsulanKP : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityUsulanKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<NamaMhs>
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_usulan_kp)

        binding = ActivityUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

//        init()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mhsList = ArrayList()

        mhsList.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011522001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523009"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))

        adapter = MyAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, DetailUsulanKP::class.java)
            startActivity(intent )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun init(){
        recyclerView = findViewById(R.id.recycler_view)

        var data = ArrayList<NamaMhs>()
        data.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011522001"))
        data.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523006"))
        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523007"))
        data.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523008"))

        adapter = MyAdapter(data)
    }

}