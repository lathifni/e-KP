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

class ListInstansiAdapterRoom(private val instList: List<id.ac.unand.e_kp.TugasBesarPribadi.data.Instansi>) : RecyclerView.Adapter<ListInstansiAdapterRoom.instansViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): instansViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_instansi, parent, false)
        return instansViewHolder(view)
    }

    override fun onBindViewHolder(holder: instansViewHolder, position: Int) {
        val currentPosition = instList[position]
        holder.namaInstansi.text = currentPosition.name
        holder.alamat.text = currentPosition.address
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

    class instansViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaInstansi : TextView = itemView.findViewById(R.id.namaInstansi)
        val alamat: TextView = itemView.findViewById(R.id.address)
        val status: ImageView = itemView.findViewById(R.id.itemStatus)
        val edit: ImageView = itemView.findViewById(R.id.itemEdit)
    }

}