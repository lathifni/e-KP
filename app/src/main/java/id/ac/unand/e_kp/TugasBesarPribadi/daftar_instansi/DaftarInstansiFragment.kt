package id.ac.unand.e_kp.TugasBesarPribadi.daftar_instansi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.*
import id.ac.unand.e_kp.adapter.InstansiAdapter
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.FragmentDaftarInstansiBinding
import id.ac.unand.e_kp.models.Instansi
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class DaftarInstansiFragment : Fragment() {

    private var _binding: FragmentDaftarInstansiBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var intList: ArrayList<Instansi>
    private lateinit var adapter: InstansiAdapter

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
        recyclerView.layoutManager = LinearLayoutManager(context)

        intList = ArrayList()
        intList.add(Instansi("PT. MULTIPOLAR"))
        intList.add(Instansi("PT. Telkom"))
        intList.add(Instansi("Kominfo"))
        intList.add(Instansi("Mediatama"))
        intList.add(Instansi("Dinas Kesehatan Sumbar"))

        adapter = InstansiAdapter(intList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : InstansiAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DaftarInstansiFragment.requireContext(), ListInstansi::class.java)
                intent.putExtra("nama", intList[position].nama)
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}