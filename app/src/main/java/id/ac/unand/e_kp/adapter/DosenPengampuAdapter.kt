package id.ac.unand.e_kp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.models.DosenPengampu

class DosenPengampuAdapter(private val dosenPengampuList : ArrayList<DosenPengampu>) : RecyclerView.Adapter<DosenPengampuAdapter.dosenPengampuViewHolder>() {

    private var isNewRadioButtonChecked = false
    private var lastCheckedPosition = -1
    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }

    inner class dosenPengampuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nama : RadioButton = itemView.findViewById(R.id.radioButton)
        init {
            nama.setOnClickListener {
                handleRadioButtonChecks(absoluteAdapterPosition, myListener)
            }
        }

        private fun handleRadioButtonChecks(adapterPosition: Int, listener: OnItemClickListener) {
            isNewRadioButtonChecked = true
            dosenPengampuList[lastCheckedPosition].isSelected = false
            dosenPengampuList[adapterPosition].isSelected = true
            lastCheckedPosition = adapterPosition
            listener.onItemClick(adapterPosition)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dosenPengampuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dosen_pengampu, parent, false)
        return dosenPengampuViewHolder(view)
    }

    override fun onBindViewHolder(holder: dosenPengampuViewHolder, position: Int) {
        val currentPosition = dosenPengampuList[position]
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
        return dosenPengampuList.size
    }
}