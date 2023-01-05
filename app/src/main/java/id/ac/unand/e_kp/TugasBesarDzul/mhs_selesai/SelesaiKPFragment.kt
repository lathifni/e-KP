package id.ac.unand.e_kp.TugasBesarDzul.mhs_selesai

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
import id.ac.unand.e_kp.TugasBesarDzul.adapter.MahasiswaSelesaiAdapter
import id.ac.unand.e_kp.TugasBesarDzul.Response.MhsSelesaiResponse
import id.ac.unand.e_kp.databinding.FragmentSelesaiKpBinding
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class SelesaiKPFragment : Fragment() {

    private var _binding: FragmentSelesaiKpBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelesaiKpBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.recyclerView4
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromAPI()
    }

    private fun getDataFromAPI(){
        val sharedPref =
            context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        val list = ArrayList<MhsSelesaiResponse.Internships>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.getMhsSelesai("Bearer $token")
        callData.enqueue(object : Callback<MhsSelesaiResponse> {
            override fun onResponse(
                call: Call<MhsSelesaiResponse>,
                response: Response<MhsSelesaiResponse>
            ) {

                val data = response.body()
                data?.internships.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }

                val adapterGet = MahasiswaSelesaiAdapter(list)
                recyclerView.adapter = adapterGet
            }

            override fun onFailure(call: Call<MhsSelesaiResponse>, t: Throwable) {
                Toast.makeText(context, "Gagal", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}