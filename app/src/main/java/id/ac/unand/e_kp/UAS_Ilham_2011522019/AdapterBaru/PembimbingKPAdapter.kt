package id.ac.unand.e_kp.UAS_Ilham_2011522019.AdapterBaru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.PembimbingKpResponse
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.UsulanKPResponse

class PembimbingKPAdapter(private val Listpembimbing: ArrayList<PembimbingKpResponse>): RecyclerView.Adapter<PembimbingKPAdapter.pembimbingViewHolder>() {
    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PembimbingKPAdapter.pembimbingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dosen_pengampu, parent, false)
        return PembimbingKPAdapter.pembimbingViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: PembimbingKPAdapter.pembimbingViewHolder, position: Int) {
        val currentPosition = Listpembimbing[position]
        holder.message.text = currentPosition.message
    }

    override fun getItemCount(): Int {
        return Listpembimbing.size
    }

    class pembimbingViewHolder(itemView: View, listener: PembimbingKPAdapter.onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val message: TextView = itemView.findViewById(R.id.simpanPembimbing)
    }
}