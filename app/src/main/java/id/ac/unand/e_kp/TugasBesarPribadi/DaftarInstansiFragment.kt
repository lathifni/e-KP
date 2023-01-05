package id.ac.unand.e_kp.TugasBesarPribadi

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
import id.ac.unand.e_kp.TugasBesarPribadi.adapter.ListInstansiAdapter
import id.ac.unand.e_kp.TugasBesarPribadi.response.ListInstansiResponse
import id.ac.unand.e_kp.TugasBesarPribadi.room.RoomDb
import id.ac.unand.e_kp.databinding.FragmentDaftarInstansiBinding
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class DaftarInstansiFragment : Fragment() {

    private var _binding: FragmentDaftarInstansiBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

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
        binding.roomBtn.setOnClickListener {
            val intent = Intent(activity?.applicationContext, RoomDb::class.java)
            startActivity(intent)
        }
    }

    private fun getDataFromAPI(){
        val sharedPref =
            context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        var list = ArrayList<ListInstansiResponse.Companies>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.getListInstansi("Bearer $token")
        callData.enqueue(object : Callback<ListInstansiResponse> {
            override fun onResponse(
                call: Call<ListInstansiResponse>,
                response: Response<ListInstansiResponse>
            ) {
                val data = response.body()
                Log.d("test", data.toString())
                data?.companies.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = ListInstansiAdapter(list)
                recyclerView.adapter = adapterGet
                adapterGet!!.notifyDataSetChanged()

                adapterGet.setOnItemClickListener(object : ListInstansiAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        var a = list[position]
                        var name = a.name
                        var address = a.address
                        Log.d("extras", a.toString())
                        var id = position+1
                        val intent = Intent(activity?.applicationContext, AccRejcInstansi::class.java)
                        intent.putExtra("id", id)
                        intent.putExtra("name", name)
                        intent.putExtra("address", address)
                        startActivity(intent)
                    }
                })
            }
            override fun onFailure(call: Call<ListInstansiResponse>, t: Throwable) {
                Toast.makeText(context, "gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}