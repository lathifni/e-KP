package id.ac.unand.e_kp.TugasBesarDzul.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.models.Mahasiswa

class MahasiswaAdapter(private val mhsList: ArrayList<Mahasiswa>) : RecyclerView.Adapter<MahasiswaAdapter.mhsListViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mhsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return mhsListViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: mhsListViewHolder, position: Int) {
        val currentPosition = mhsList[position]
        holder.namaMahasiswa.text = currentPosition.nama
        holder.nimMahasiswa.text = currentPosition.nim
    }

    override fun getItemCount(): Int {
        return mhsList.size
    }

    class mhsListViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaMahasiswa : TextView = itemView.findViewById(R.id.tvtext1)
        val nimMahasiswa : TextView = itemView.findViewById(R.id.tvtext2)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}