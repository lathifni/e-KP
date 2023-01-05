package id.ac.unand.e_kp.TugasBesarPribadi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import id.ac.unand.e_kp.Home
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarPribadi.response.PatchInstansiResponse
import id.ac.unand.e_kp.databinding.ActivityAccRejcInstansiBinding
import id.ac.unand.e_kp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccRejcInstansi : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private  lateinit var binding: ActivityAccRejcInstansiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccRejcInstansiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar1)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        val bundle: Bundle? = intent.extras
        val id = bundle!!.getInt("id")
        val name = bundle!!.getString("name")
        val address = bundle!!.getString("address")

        binding.namaPerusahaanTV.setText(name)
        binding.alamatPerusahaanTV.setText(address)

        binding.simpanAccRejc.setOnClickListener {
            var selectedRadioButtonId: Int = binding.radioGroup.checkedRadioButtonId
            if(selectedRadioButtonId!= -1){
                val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
                var pilihan = selectedRadioButton.text.toString()
                if (pilihan.equals("Setuju")){
                    val retrofitClient = RetrofitClient.create()
                    val patchData = retrofitClient.patchAccRejcInstansi("Bearer $token", id, 1)
                    patchData.enqueue(object : Callback<PatchInstansiResponse> {
                        override fun onResponse(
                            call: Call<PatchInstansiResponse>,
                            response: Response<PatchInstansiResponse>
                        ) {
                            Toast.makeText(this@AccRejcInstansi, "berhasil mengganti status", Toast.LENGTH_SHORT).show()
                        }
                        override fun onFailure(call: Call<PatchInstansiResponse>, t: Throwable) {
                            Toast.makeText(this@AccRejcInstansi, "gagal", Toast.LENGTH_SHORT).show()
                        }
                    })
                }else{
                    val retrofitClient = RetrofitClient.create()
                    val patchData = retrofitClient.patchAccRejcInstansi("Bearer $token", id, 2)
                    patchData.enqueue(object : Callback<PatchInstansiResponse> {
                        override fun onResponse(
                            call: Call<PatchInstansiResponse>,
                            response: Response<PatchInstansiResponse>
                        ) {
                            Toast.makeText(this@AccRejcInstansi, "berhasil mengganti status", Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<PatchInstansiResponse>, t: Throwable) {
                            Toast.makeText(this@AccRejcInstansi, "gagal", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
                binding.radioGroup.clearCheck()
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Anda belum memilih di radio button", Toast.LENGTH_SHORT).show()
            }
        }
    }



}