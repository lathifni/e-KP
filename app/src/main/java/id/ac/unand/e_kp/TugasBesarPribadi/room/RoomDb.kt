package id.ac.unand.e_kp.TugasBesarPribadi.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarPribadi.data.Instansi
import id.ac.unand.e_kp.TugasBesarPribadi.data.InstansiDatabase
import id.ac.unand.e_kp.databinding.ActivityRoomDbBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomDb : AppCompatActivity() {
    private lateinit var binding: ActivityRoomDbBinding
    private lateinit var appDb: InstansiDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar1)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        appDb = InstansiDatabase.getDatabase(this)

        binding.btnSave.setOnClickListener {
            writeData()
        }

        binding.btnRead.setOnClickListener {
            readData()
        }

        binding.btnDetailRV.setOnClickListener {
            val intent = Intent(this, ListInstansiRoom::class.java)
            startActivity(intent)
        }
    }

    private fun writeData(){
        val name = binding.etNameInstansi.text.toString()
        val address = binding.etAddressInstansi.text.toString()
        val status = binding.etStatus.text.toString()

        if (name.isNotEmpty() && address.isNotEmpty() && status.isNotEmpty()){
            val instansi = Instansi(null, name, address, status.toInt())
            GlobalScope.launch(Dispatchers.IO) {
                appDb.instansiDao().addInstansi(instansi)
            }
            binding.etNameInstansi.text.clear()
            binding.etAddressInstansi.text.clear()
            binding.etStatus.text.clear()
            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Masukkan data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readData(){
        val cariId = binding.etIdPerusahaan.text.toString()
        if (cariId.isNotEmpty()){
            lateinit var instansi: Instansi
            GlobalScope.launch {
                instansi = appDb.instansiDao().findById(cariId.toInt())
                displayData(instansi)
            }
        }
    }

    private suspend fun displayData(instansi: Instansi){
        withContext(Dispatchers.Main) {
            binding.tvFirstName.text = instansi.name
            binding.tvLastName.text = instansi.address
            if(instansi.status == 0){
                binding.tvRollNo.text = "Belum ditentukan"
            }else if(instansi.status == 1){
                binding.tvRollNo.text = "Disetujui"
            }else{
                binding.tvRollNo.text = "Tidak disetujui"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}