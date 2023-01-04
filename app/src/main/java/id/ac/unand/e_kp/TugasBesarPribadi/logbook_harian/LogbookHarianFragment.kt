package id.ac.unand.e_kp.TugasBesarPribadi.logbook_harian

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.TugasBesarPribadi.adapter.LogbookHarianAdapter
import id.ac.unand.e_kp.TugasBesarPribadi.response.LogbookHarianResponse
import id.ac.unand.e_kp.adapter.LogbookAdapter
import id.ac.unand.e_kp.databinding.FragmentLogbookHarianBinding
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class LogbookHarianFragment : Fragment() {

    private var _binding: FragmentLogbookHarianBinding? = null
    private val binding get() = _binding!!

    lateinit var recyclerView: RecyclerView
//    private lateinit var mhsList: ArrayList<Mahasiswa>
//    private lateinit var adapter: MahasiswaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogbookHarianBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.recyclerView2
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromAPI()

//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        mhsList = ArrayList()
//
//        mhsList.add(Mahasiswa("Ilham", "2011522019"))
//        mhsList.add(Mahasiswa("Dzul Fauzi", "2011521001"))
//        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523009"))
//        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523001"))
//        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))
//
//        adapter = MahasiswaAdapter(mhsList)
//        recyclerView.adapter = adapter
//
//        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@LogbookHarianFragment.requireContext(), LogbookKP::class.java)
//                intent.putExtra("nama", mhsList[position].nama)
//                intent.putExtra("nim", mhsList[position].nim)
//                startActivity(intent)
//            }
//        })
    }

    private fun getDataFromAPI() {
        val sharedPref =
            context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        val list = ArrayList<LogbookHarianResponse.Logbooks>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.getLogbookHarian("Bearer $token")
        callData.enqueue(object : Callback<LogbookHarianResponse> {
            override fun onResponse(
                call: Call<LogbookHarianResponse>,
                response: Response<LogbookHarianResponse>
            ) {
                Toast.makeText(context, "Berhasil nih", Toast.LENGTH_SHORT).show()
//                Log.d("Hasilnya nih", response.body().toString())
                val data = response.body()
                data?.logbooks.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = LogbookHarianAdapter(list)
                recyclerView.adapter = adapterGet
            }

            override fun onFailure(call: Call<LogbookHarianResponse>, t: Throwable) {
                Toast.makeText(context, "Yah gagal", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}