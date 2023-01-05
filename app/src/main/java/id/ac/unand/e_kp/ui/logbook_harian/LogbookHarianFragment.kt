package id.ac.unand.e_kp.ui.logbook_harian

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.*
import id.ac.unand.e_kp.TugasBesarDzul.Adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.FragmentLogbookHarianBinding
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class LogbookHarianFragment : Fragment() {

    private var _binding: FragmentLogbookHarianBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<Mahasiswa>
    private lateinit var adapter: MahasiswaAdapter

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
        recyclerView.layoutManager = LinearLayoutManager(context)

        mhsList = ArrayList()

        mhsList.add(Mahasiswa("Ilham", "2011522019"))
        mhsList.add(Mahasiswa("Dzul Fauzi", "2011521001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523009"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523001"))
        mhsList.add(Mahasiswa("Lathif Nur Irsyad", "2011523004"))

        adapter = MahasiswaAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@LogbookHarianFragment.requireContext(), LogbookKP::class.java)
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