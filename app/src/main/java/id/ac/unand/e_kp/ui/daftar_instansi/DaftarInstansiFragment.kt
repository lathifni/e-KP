package id.ac.unand.e_kp.ui.daftar_instansi

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
import id.ac.unand.e_kp.adapter.MahasiswaAdapter
import id.ac.unand.e_kp.databinding.FragmentDaftarInstansiBinding
import id.ac.unand.e_kp.models.Mahasiswa
import java.util.ArrayList

class DaftarInstansiFragment : Fragment() {

    private var _binding: FragmentDaftarInstansiBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<Mahasiswa>
    private lateinit var adapter: MahasiswaAdapter

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

        mhsList = ArrayList()

        mhsList.add(Mahasiswa("Daftar Instansi", "2011523004"))
        mhsList.add(Mahasiswa("Daftar Instansi", "201152300"))
        mhsList.add(Mahasiswa("Daftar Instansi", "2011523009"))
        mhsList.add(Mahasiswa("Daftar Instansi", "2011523001"))
        mhsList.add(Mahasiswa("Daftar Instansi", "2011523004"))

        adapter = MahasiswaAdapter(mhsList)
        recyclerView.adapter = adapter

//        adapter.onItemClick = {
//            val intent = Intent(context, ListInstansi::class.java)
//            startActivity(intent )
//        }
        adapter.setOnItemClickListener(object : MahasiswaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DaftarInstansiFragment.requireContext(), ListInstansi::class.java)
//                intent.putExtra("nama", mhsList[position].txtTitle)
//                intent.putExtra("nim", mhsList[position].txtSubTitle)
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}