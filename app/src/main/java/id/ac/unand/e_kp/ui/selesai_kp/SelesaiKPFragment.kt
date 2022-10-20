package id.ac.unand.e_kp.ui.selesai_kp

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
import id.ac.unand.e_kp.adapter.MahasiswaSelesaiAdapter
import id.ac.unand.e_kp.databinding.FragmentSelesaiKpBinding
import id.ac.unand.e_kp.models.MahasiswaSelesai
import java.util.ArrayList

class SelesaiKPFragment : Fragment() {
    private var _binding: FragmentSelesaiKpBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsListSelesai: ArrayList<MahasiswaSelesai>
    private lateinit var adapter: MahasiswaSelesaiAdapter

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
        recyclerView.layoutManager = LinearLayoutManager(context)

        mhsListSelesai = ArrayList()

        mhsListSelesai.add(MahasiswaSelesai("Ilham", "2011522019"))
        mhsListSelesai.add(MahasiswaSelesai("Dzul Fauzi", "2011522001"))
        mhsListSelesai.add(MahasiswaSelesai("Lathif Nur Irsyad", "201152300"))
        mhsListSelesai.add(MahasiswaSelesai("Fikri", "2011523000"))
        mhsListSelesai.add(MahasiswaSelesai("lyl", "2011522029"))

        adapter = MahasiswaSelesaiAdapter(mhsListSelesai)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MahasiswaSelesaiAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@SelesaiKPFragment.requireContext(), DetailLaporanKP::class.java)
                intent.putExtra("nama", mhsListSelesai[position].nama)
                intent.putExtra("nim", mhsListSelesai[position].nim)
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}