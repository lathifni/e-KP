package id.ac.unand.e_kp.TugasBesarPribadi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarPribadi.response.ListInstansiResponse
import id.ac.unand.e_kp.models.Instansi

class ListInstansiAdapter(private val instList: ArrayList<ListInstansiResponse.Companies>) : RecyclerView.Adapter<ListInstansiAdapter.instansViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): instansViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_instansi, parent, false)
        return instansViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: instansViewHolder, position: Int) {
        val currentPosition = instList[position]
        holder.namaInstansi.text = currentPosition.name
        holder.alamat.text = currentPosition.address
//        holder.status.setImageDrawable()
        if (currentPosition.status == 0){
            holder.status.setImageResource(R.drawable.question)
        }else if(currentPosition.status == 1){
            holder.status.setImageResource(R.drawable.checklist)
        }else{
            holder.status.setImageResource(R.drawable.silang)
        }
    }

    override fun getItemCount(): Int {
        return instList.size
    }

    class instansViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaInstansi : TextView = itemView.findViewById(R.id.namaInstansi)
        val alamat: TextView = itemView.findViewById(R.id.address)
        val status: ImageView = itemView.findViewById(R.id.itemStatus)
        val edit: ImageView = itemView.findViewById(R.id.itemEdit)
        init {
            edit.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}