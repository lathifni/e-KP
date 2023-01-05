package id.ac.unand.e_kp.TugasBesarDzul.usulan_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.DetailUsulanKP
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarDzul.Adapter.MahasiswaAdapter
import id.ac.unand.e_kp.TugasBesarDzul.Response.MhsSelesaiResponse
import id.ac.unand.e_kp.TugasBesarDzul.Response.UsulanResponse
import id.ac.unand.e_kp.TugasBesarDzul.adapter.MahasiswaSelesaiAdapter
import id.ac.unand.e_kp.databinding.ActivityUsulanKpBinding
import id.ac.unand.e_kp.models.Mahasiswa
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class UsulanKP : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityUsulanKpBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<Mahasiswa>
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mhsList = ArrayList()
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011522001"))
        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523009"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))

        adapter = MahasiswaAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@UsulanKP, DetailUsulanKP::class.java)
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