package id.ac.unand.e_kp.TugasBesarPribadi.daftar_instansi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.*
import id.ac.unand.e_kp.TugasBesarPribadi.adapter.ListInstansiAdapter
import id.ac.unand.e_kp.TugasBesarPribadi.response.ListInstansiResponse
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.FragmentDaftarInstansiBinding
import id.ac.unand.e_kp.models.Instansi
import id.ac.unand.e_kp.models.Mahasiswa
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class DaftarInstansiFragment : Fragment() {

    private var _binding: FragmentDaftarInstansiBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
//    private lateinit var intList: ArrayList<Instansi>
//    private lateinit var adapter: ListInstansiAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaftarInstansiBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.recyclerView3
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataFromAPI()
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        intList = ArrayList()
//        intList.add(Instansi("PT. MULTIPOLAR"))
//        intList.add(Instansi("PT. Telkom"))
//        intList.add(Instansi("Kominfo"))
//        intList.add(Instansi("Mediatama"))
//        intList.add(Instansi("Dinas Kesehatan Sumbar"))
//
//        adapter = InstansiAdapter(intList)
//        recyclerView.adapter = adapter
//
//        adapter.setOnItemClickListener(object : InstansiAdapter.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@DaftarInstansiFragment.requireContext(), ListInstansi::class.java)
//                intent.putExtra("nama", intList[position].nama)
//                startActivity(intent)
//            }
//        })
    }

    private fun getDataFromAPI(){
        val sharedPref =
            context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        val list = ArrayList<ListInstansiResponse.Companies>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.getListInstansi("Bearer $token")
        callData.enqueue(object : Callback<ListInstansiResponse> {
            override fun onResponse(
                call: Call<ListInstansiResponse>,
                response: Response<ListInstansiResponse>
            ) {
                Toast.makeText(context, "Berhasil nih", Toast.LENGTH_SHORT).show()
                Log.d("Hasilnya nih", response.body().toString())
                val data = response.body()
                data?.companies.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = ListInstansiAdapter(list)
                recyclerView.adapter = adapterGet

                adapterGet.setOnItemClickListener(object : ListInstansiAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "tombol edit", Toast.LENGTH_SHORT).show()
                    }

                })
            }

            override fun onFailure(call: Call<ListInstansiResponse>, t: Throwable) {
                Toast.makeText(context, "Yah gagal", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}