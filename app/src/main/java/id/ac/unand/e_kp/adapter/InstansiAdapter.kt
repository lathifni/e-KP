package id.ac.unand.e_kp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.models.Instansi

class InstansiAdapter(private val instList: ArrayList<Instansi>) : RecyclerView.Adapter<InstansiAdapter.instnsViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): instnsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_instansi, parent, false)
        return instnsViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: instnsViewHolder, position: Int) {
        val currentPosition = instList[position]
        holder.namaMahasiswa.text = currentPosition.nama
    }

    override fun getItemCount(): Int {
        return instList.size
    }

    class instnsViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaMahasiswa : TextView = itemView.findViewById(R.id.namainstansi)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}