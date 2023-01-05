package id.ac.unand.e_kp.ui.home

import android.content.Context
import android.content.Intent
import android.media.MediaCodec.MetricsConstants.MODE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.*
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.ContentHomeBinding
//import androidx.lifecycle.ViewModelProvider
import id.ac.unand.e_kp.databinding.FragmentHomeBinding
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<Mahasiswa>
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.recyclerView3

        binding.button4.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), UsulanKP::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), DetailKPMahasiswa::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().applicationContext.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN : ", token)
        }
        recyclerView.layoutManager = LinearLayoutManager(context)

        mhsList = ArrayList()

        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011521001"))
        mhsList.add(Mahasiswa("Rizki Juni Darmawan", "2011527001"))
        mhsList.add(Mahasiswa("Iqbal Manazil Yuni", "2011522007"))
        mhsList.add(Mahasiswa("Fadila Tri Afriani", "2011521011"))
        mhsList.add(Mahasiswa("Aini Izzathy Ispendi ", "201152025"))

        adapter = MahasiswaAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@HomeFragment.requireContext(), LogbookKP::class.java)
                intent.putExtra("nama", mhsList[position].nama)
                intent.putExtra("nim", mhsList[position].nim)
                startActivity(intent)
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}