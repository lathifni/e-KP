package id.ac.unand.e_kp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import id.ac.unand.e_kp.Home
import id.ac.unand.e_kp.MahasiswaKP
import id.ac.unand.e_kp.UsulanKP
//import androidx.lifecycle.ViewModelProvider
import id.ac.unand.e_kp.databinding.FragmentHomeBinding
import kotlin.concurrent.timerTask

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button4.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), UsulanKP::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), MahasiswaKP::class.java)
            startActivity(intent)
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}