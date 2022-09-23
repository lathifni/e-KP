package id.ac.unand.e_kp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val mhsList: ArrayList<NamaMhs>): RecyclerView.Adapter<MyAdapter.namaMhsViewHolder>() {
    var onItemClick: ((NamaMhs)-> Unit)?= null

    class namaMhsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.img_view)
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        val txtSubTitle: TextView = itemView.findViewById(R.id.txt_sub_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): namaMhsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_template, parent, false)
        return namaMhsViewHolder(view)
    }

    override fun onBindViewHolder(holder: namaMhsViewHolder, position: Int) {
        val mhs = mhsList[position]
        holder.imageView.setImageResource(mhs.imgView)
        holder.txtTitle.text = mhs.txtTitle
        holder.txtSubTitle.text = mhs.txtSubTitle

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(mhs)
        }
    }

    override fun getItemCount(): Int {
        return mhsList.size
    }
}