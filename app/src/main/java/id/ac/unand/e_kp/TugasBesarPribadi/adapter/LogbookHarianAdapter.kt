package id.ac.unand.e_kp.TugasBesarPribadi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.TugasBesarPribadi.response.LogbookHarianResponse
import id.ac.unand.e_kp.adapter.MahasiswaAdapter

class LogbookHarianAdapter(private val logbookHarianList: ArrayList<LogbookHarianResponse.Logbooks>):
RecyclerView.Adapter<LogbookHarianAdapter.logbookHarianViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logbookHarianViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logbook_harian, parent, false)
        return LogbookHarianAdapter.logbookHarianViewHolder(view)
    }

    override fun onBindViewHolder(holder: logbookHarianViewHolder, position: Int) {
        val currentPostion = logbookHarianList[position]
        holder.name.text = currentPostion.name
        holder.NIM.text = currentPostion.nim
        holder.startAt.text = currentPostion.startAt
        holder.endAt.text = currentPostion.endAt
        holder.activities.text = currentPostion.activities
    }

    override fun getItemCount(): Int {
        return logbookHarianList.size
    }

    class logbookHarianViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.logbookHarianName)
        val NIM: TextView = itemView.findViewById(R.id.logbookHarianNIM)
        val startAt: TextView = itemView.findViewById(R.id.logbookHarianStartAt)
        val endAt: TextView = itemView.findViewById(R.id.logbookHarianEndAt)
        val activities: TextView = itemView.findViewById(R.id.logbookHarianActivities)
    }
}