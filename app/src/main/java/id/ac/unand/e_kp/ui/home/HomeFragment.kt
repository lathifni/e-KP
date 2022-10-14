package id.ac.unand.e_kp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.*
//import androidx.lifecycle.ViewModelProvider
import id.ac.unand.e_kp.databinding.FragmentHomeBinding
import java.util.ArrayList

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsList: ArrayList<NamaMhs>
    private lateinit var adapter: MyAdapter

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
        recyclerView.layoutManager = LinearLayoutManager(context)

        mhsList = ArrayList()

        mhsList.add(NamaMhs(R.drawable.ic_person2, "Ilham", "2011522019"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Dzul Fauzi", "2011521001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523009"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523001"))
        mhsList.add(NamaMhs(R.drawable.ic_person2, "Lathif Nur Irsyad", "2011523004"))

        adapter = MyAdapter(mhsList)
        recyclerView.adapter = adapter

//        adapter.onItemClick = {
//            val intent = Intent(context, LogbookKP::class.java)
//            startActivity(intent )
//        }
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@HomeFragment.requireContext(), LogbookKP::class.java)
                intent.putExtra("nama", mhsList[position].txtTitle)
                intent.putExtra("nim", mhsList[position].txtSubTitle)
                startActivity(intent)
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}