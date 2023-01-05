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
import id.ac.unand.e_kp.UAS_Ilham_2011522019.AdapterBaru.ListLogbookKPAdapter
import id.ac.unand.e_kp.UAS_Ilham_2011522019.AdapterBaru.ListUsulanKpAdapter
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.ListLogbookKPResponse
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.UsulanKPResponse
import id.ac.unand.e_kp.adapter.LogbookAdapter
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.ActivityKonfirmasiBatalKpBinding
import id.ac.unand.e_kp.databinding.ActivityLogbookKpBinding
import id.ac.unand.e_kp.databinding.FragmentLogbookHarianBinding
import id.ac.unand.e_kp.models.Logbook
import id.ac.unand.e_kp.models.Mahasiswa
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class LogbookKP : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityLogbookKpBinding
    private lateinit var recyclerView: RecyclerView
//    private lateinit var mhsLogbook: ArrayList<Logbook>
//    private lateinit var adapter: LogbookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogbookKpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar5)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view6)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getDataFromAPI()

//        val bundle : Bundle? = intent.extras
//        val nama = bundle!!.getString("nama")
//        val nim = bundle!!.getString("nim")
//
//        binding.textView15.text = nama
//        binding.textView16.text = nim
//
//        mhsLogbook = ArrayList()
//        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
//        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
//        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
//        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
//        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
//        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
//        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
//        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
//        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
//        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
//        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
//        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
//        mhsLogbook.add(Logbook("Mendiskusikan project", "20/09/2022"))
//        mhsLogbook.add(Logbook("Meeting", "21/09/2022"))
//        mhsLogbook.add(Logbook("Yoo Ndak Lah Kok Nanya Saya", "22/09/2022"))
//
//
//        adapter = LogbookAdapter(mhsLogbook)
//        recyclerView.adapter = adapter
//
//        adapter.setOnItemClickListener(object : LogbookAdapter.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@LogbookKP, DetailLogbook::class.java)
//                intent.putExtra("kegiatan", mhsLogbook[position].kegiatan)
//                intent.putExtra("tanggal", mhsLogbook[position].tanggal)
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

        val list = ArrayList<ListLogbookKPResponse.Logbooks>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.logbook("Bearer $token")
        callData.enqueue(object : Callback<ListLogbookKPResponse> {
            override fun onResponse(
                call: Call<ListLogbookKPResponse>,
                response: Response<ListLogbookKPResponse>
            ) {
                Toast.makeText(applicationContext, "Berhasil Mengload Data", Toast.LENGTH_SHORT).show()
//                Log.d("Hasilnya nih", response.body().toString())
                val data = response.body()
                data?.logbooks.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = ListLogbookKPAdapter(list)
                recyclerView.adapter = adapterGet
            }
            override fun onFailure(call: Call<ListLogbookKPResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Gagal Mengload Data", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}