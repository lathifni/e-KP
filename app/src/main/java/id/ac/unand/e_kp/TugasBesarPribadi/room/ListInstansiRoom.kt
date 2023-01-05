package id.ac.unand.e_kp.TugasBesarPribadi.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unand.e_kp.TugasBesarPribadi.adapter.ListInstansiAdapter
import id.ac.unand.e_kp.TugasBesarPribadi.adapter.ListInstansiAdapterRoom
import id.ac.unand.e_kp.TugasBesarPribadi.data.Instansi
import id.ac.unand.e_kp.TugasBesarPribadi.data.InstansiDatabase
import id.ac.unand.e_kp.databinding.ActivityListInstansiRoomBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListInstansiRoom : AppCompatActivity() {
    private lateinit var binding: ActivityListInstansiRoomBinding
    lateinit var instansi: List<Instansi>
    private lateinit var adapter: ListInstansiAdapterRoom
    private lateinit var appDb: InstansiDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListInstansiRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar1)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val rvRoom = binding.recyclerViewRoomDb
        appDb = InstansiDatabase.getDatabase(this)

        GlobalScope.launch {
            instansi = appDb.instansiDao().readAllData()
            Log.d("Roomnya", instansi.toString())
            rvRoom.layoutManager = LinearLayoutManager(this@ListInstansiRoom)
            rvRoom.setHasFixedSize(true)
            adapter = ListInstansiAdapterRoom(instansi)
            rvRoom.adapter = adapter
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}