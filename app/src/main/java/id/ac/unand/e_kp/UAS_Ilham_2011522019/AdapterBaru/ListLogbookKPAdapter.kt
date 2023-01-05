package id.ac.unand.e_kp.UAS_Ilham_2011522019.AdapterBaru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.e_kp.R
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.ListLogbookKPResponse

class ListLogbookKPAdapter(private val logbooklist: ArrayList<ListLogbookKPResponse.Logbooks>): RecyclerView.Adapter<ListLogbookKPAdapter.logbookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logbookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_logbook, parent, false)
        return ListLogbookKPAdapter.logbookViewHolder(view)
    }

    override fun onBindViewHolder(holder: logbookViewHolder, position: Int) {
        val currentPostion = logbooklist[position]
        holder.id.text = currentPostion.id.toString()
        holder.internship.text = currentPostion.internship_id.toString()
        holder.date.text = currentPostion.date
        holder.activities.text = currentPostion.activities
        holder.note.text = currentPostion.note
        holder.status.text = currentPostion.status.toString()
        holder.created.text = currentPostion.created_at
        holder.updated.text = currentPostion.updated_at
    }
    override fun getItemCount(): Int {
        return logbooklist.size
    }

    class logbookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.idLogbook)
        val internship: TextView = itemView.findViewById(R.id.internshipLogbook)
        val date: TextView = itemView.findViewById(R.id.dateLogbook)
        val activities: TextView = itemView.findViewById(R.id.activitiesLogbook)
        val note: TextView = itemView.findViewById(R.id.noteLogbook)
        val status: TextView = itemView.findViewById(R.id.noteLogbook)
        val created: TextView = itemView.findViewById(R.id.mulaiLogbook)
        val updated: TextView = itemView.findViewById(R.id.updateLogbook)


    }
}