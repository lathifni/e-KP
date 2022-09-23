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
import id.ac.unand.e_kp.DetailUsulanKP
import id.ac.unand.e_kp.MyAdapter
import id.ac.unand.e_kp.NamaMhs
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.databinding.FragmentSelesaiKpBinding
import java.util.ArrayList

class SelesaiKPFragment : Fragment() {
    private var _binding: FragmentSelesaiKpBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<NamaMhs>
    private lateinit var adapter: MyAdapter

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

        mhsList = ArrayList()

        mhsList.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523004"))
        mhsList.add(NamaMhs(R.drawable.ic_person, "Selesai KP", "201152300"))
        mhsList.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523009"))
        mhsList.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523001"))
        mhsList.add(NamaMhs(R.drawable.ic_person, "Lathif Nur Irsyad", "2011523004"))

        adapter = MyAdapter(mhsList)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(context, DetailUsulanKP::class.java)
            startActivity(intent )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}