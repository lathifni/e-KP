package id.ac.unand.e_kp.UAS_Ilham_2011522019.AdapterBaru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.UsulanKPResponse

class ListUsulanKpAdapter(private val Listusulan: ArrayList<UsulanKPResponse.Proposals>) : RecyclerView.Adapter<ListUsulanKpAdapter.usulanViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): usulanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usulan_kp, parent, false)
        return usulanViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: usulanViewHolder, position: Int) {
        val currentPosition = Listusulan[position]
        holder.idusulan.text = currentPosition.id.toString()
        holder.nameinstansi.text = currentPosition.name
        holder.mulai.text = currentPosition.start_at
        holder.akhir.text = currentPosition.end_at
        holder.numusulan.text = currentPosition.num.toString()
    }

    override fun getItemCount(): Int {
        return Listusulan.size
    }

    class usulanViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val idusulan: TextView = itemView.findViewById(R.id.idUsulan)
        val nameinstansi : TextView = itemView.findViewById(R.id.nameinstansi)
        val mulai: TextView = itemView.findViewById(R.id.mulaikp)
        val akhir: TextView = itemView.findViewById(R.id.berakhirkp)
        val numusulan: TextView = itemView.findViewById(R.id.numUsulan)
    }
}