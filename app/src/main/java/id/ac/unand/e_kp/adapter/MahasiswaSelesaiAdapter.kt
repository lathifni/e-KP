package id.ac.unand.e_kp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.models.MahasiswaSelesai

class MahasiswaSelesaiAdapter(private val mhsListSelesai: ArrayList<MahasiswaSelesai>) : RecyclerView.Adapter<MahasiswaSelesaiAdapter.mhsListSelesaiViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mhsListSelesaiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usulan_kp, parent, false)
        return mhsListSelesaiViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: mhsListSelesaiViewHolder, position: Int) {
        val currentPosition = mhsListSelesai[position]
        holder.namaMahasiswa.text = currentPosition.nama
        holder.nimMahasiswa.text = currentPosition.nim
    }

    override fun getItemCount(): Int {
        return mhsListSelesai.size
    }

    class mhsListSelesaiViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaMahasiswa : TextView = itemView.findViewById(R.id.textNamaMahasiswa)
        val nimMahasiswa : TextView = itemView.findViewById(R.id.textNimMahasiswa)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}