package id.ac.unand.e_kp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.models.Logbook

class LogbookAdapter(private val listLogbook:ArrayList<Logbook>): RecyclerView.Adapter<LogbookAdapter.logbookViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    class logbookViewHolder(itemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val kegiatan: TextView = itemView.findViewById(R.id.logbook1)
        val tanggal: TextView = itemView.findViewById(R.id.logbook2)

        init {
            itemView.setOnClickListener {listener.onItemClick(absoluteAdapterPosition)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logbookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logbook, parent, false)
        return logbookViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: logbookViewHolder, position: Int) {
        val posisi = listLogbook[position]
        holder.kegiatan.text = posisi.kegiatan
        holder.tanggal.text = posisi.tanggal
    }

    override fun getItemCount(): Int {
        return listLogbook.size
    }
}