package id.ac.unand.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.UAS_Ilham_2011522019.AdapterBaru.ListUsulanKpAdapter
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.UsulanKPResponse
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.ActivityUsulanKpBinding
import id.ac.unand.e_kp.models.Mahasiswa
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class UsulanKP : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityUsulanKpBinding
    private lateinit var recyclerView: RecyclerView
//    private lateinit var mhsList: ArrayList<UsulanKPResponse>
//    private lateinit var adapter: ListUsulanKpAdapter


    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view_usulan)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getDataFromAPI()
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        mhsList = ArrayList()
//        mhsList.add(Mahasiswa("Dzul Fauzi", "2011522001"))
//        mhsList.add(Mahasiswa("Ilham", "2011522019"))
//        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523009"))
//        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523001"))
//        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
//
//        adapter = MahasiswaAdapter(mhsList)
//        recyclerView.adapter = adapter
//
//        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@UsulanKP, DetailUsulanKP::class.java)
//                intent.putExtra("nama", mhsList[position].nama)
//                intent.putExtra("nim", mhsList[position].nim)
//                startActivity(intent)
//            }
//        })
    }

    private fun getDataFromAPI(){
        val sharedPreferences = applicationContext?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPreferences.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        val list = ArrayList<UsulanKPResponse.Proposals>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.detail_usulan("Bearer $token")
        callData.enqueue(object : Callback<UsulanKPResponse> {
            override fun onResponse(
                call: Call<UsulanKPResponse>,
                response: Response<UsulanKPResponse>
            ) {
                Toast.makeText(applicationContext, "Berhasil mengload data", Toast.LENGTH_SHORT).show()
//                Log.d("Hasilnya nih", response.body().toString())
                val data = response.body()
                data?.proposals.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = ListUsulanKpAdapter(list)
                recyclerView.adapter = adapterGet
//
//                adapterGet.setOnItemClickListener(object : ListUsulanKpAdapter.onItemClickListener {
//                    override fun onItemClick(position: Int) {
//                        Toast.makeText(applicationContext, "tombol edit", Toast.LENGTH_SHORT).show()
//                    }
//
//                })
            }
            override fun onFailure(call: Call<UsulanKPResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Gagal mengload data", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}