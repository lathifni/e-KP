package id.ac.unand.e_kp.TugasBesarDzul.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarDzul.Response.UsulanResponse

class MahasiswaAdapter(private val mhsList: ArrayList<UsulanResponse.Proposals>) : RecyclerView.Adapter<MahasiswaAdapter.mhsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mhsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return mhsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: mhsListViewHolder, position: Int) {
        val currentPosition = mhsList[position]
        holder.namaInstansi.text = currentPosition.name
        holder.mulai.text = currentPosition.startAt
    }

    override fun getItemCount(): Int {
        return mhsList.size
    }

    class mhsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaInstansi : TextView = itemView.findViewById(R.id.tvtext1)
        val mulai : TextView = itemView.findViewById(R.id.tvtext2)
    }

}