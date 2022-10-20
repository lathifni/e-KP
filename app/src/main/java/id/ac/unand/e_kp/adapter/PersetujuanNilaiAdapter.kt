package id.ac.unand.e_kp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.models.PersetujuaanNilai

class PersetujuanNilaiAdapter (private val persetujuanNilaiList : ArrayList<PersetujuaanNilai>) : RecyclerView.Adapter<PersetujuanNilaiAdapter.persetujuanNilaiViewHolder>()  {

    private var isNewRadioButtonChecked = false
    private var lastCheckedPosition = -1
    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }

    inner class persetujuanNilaiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nama : RadioButton = itemView.findViewById(R.id.radioButton)
        init {
            nama.setOnClickListener {
                handleRadioButtonChecks(absoluteAdapterPosition, myListener)
            }
        }

        private fun handleRadioButtonChecks(adapterPosition: Int, listener: OnItemClickListener) {
            isNewRadioButtonChecked = true
            persetujuanNilaiList[lastCheckedPosition].isSelected = true
            persetujuanNilaiList[adapterPosition].isSelected = true
            lastCheckedPosition = adapterPosition
            listener.onItemClick(adapterPosition)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): persetujuanNilaiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_persetujuan_nilai, parent, false)
        return persetujuanNilaiViewHolder(view)
    }

    override fun onBindViewHolder(holder: persetujuanNilaiViewHolder, position: Int) {
        val currentPosition = persetujuanNilaiList[position]
        holder.nama.setText(currentPosition.nama)
        if (isNewRadioButtonChecked){
            holder.nama.isChecked = currentPosition.isSelected
        }else{
            if (holder.absoluteAdapterPosition == 0){
                holder.nama.isChecked = false
                lastCheckedPosition = 0
            }
        }
    }

    override fun getItemCount(): Int {
        return persetujuanNilaiList.size
    }
}