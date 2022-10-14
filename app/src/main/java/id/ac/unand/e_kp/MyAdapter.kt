package id.ac.unand.e_kp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val mhsList: ArrayList<NamaMhs>): RecyclerView.Adapter<MyAdapter.namaMhsViewHolder>() {
//    var onItemClick: ((NamaMhs)-> Unit)?= null

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): namaMhsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_template, parent, false)
        return namaMhsViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: namaMhsViewHolder, position: Int) {
        val mhs = mhsList[position]
        holder.imageView.setImageResource(mhs.imgView)
        holder.txtTitle.text = mhs.txtTitle
        holder.txtSubTitle.text = mhs.txtSubTitle

//        holder.itemView.setOnClickListener{
//            onItemClick?.invoke(mhs)
//        }
    }

    override fun getItemCount(): Int {
        return mhsList.size
    }

    class namaMhsViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.img_view)
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        val txtSubTitle: TextView = itemView.findViewById(R.id.txt_sub_title)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}