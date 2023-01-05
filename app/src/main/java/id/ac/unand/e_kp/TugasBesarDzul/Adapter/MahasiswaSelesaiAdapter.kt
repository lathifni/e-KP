package id.ac.unand.e_kp.TugasBesarDzul.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarDzul.Response.MhsSelesaiResponse

class MahasiswaSelesaiAdapter(private val mhsListSelesai: ArrayList<MhsSelesaiResponse.Internships>) : RecyclerView.Adapter<MahasiswaSelesaiAdapter.mhsListSelesaiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mhsListSelesaiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return mhsListSelesaiViewHolder(view)
    }

    override fun onBindViewHolder(holder: mhsListSelesaiViewHolder, position: Int) {
        val currentPosition = mhsListSelesai[position]
        holder.namaMahasiswa.text = currentPosition.name
        holder.nimMahasiswa.text  = currentPosition.nim
    }

    override fun getItemCount(): Int {
        return mhsListSelesai.size
    }

    class mhsListSelesaiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaMahasiswa : TextView = itemView.findViewById(R.id.tvtext1)
        val nimMahasiswa  : TextView = itemView.findViewById(R.id.tvtext2)
    }
}