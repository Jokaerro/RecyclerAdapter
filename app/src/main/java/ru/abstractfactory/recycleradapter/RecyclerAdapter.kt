package ru.abstractfactory.recycleradapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso


class RecyclerAdapter(
        private val mContext: Context,
        private var data: ArrayList<RecyclerAdapterItem>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.recycler_adapter_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.description.text = data[position].description

        Picasso.get().load(data[position].imageUrl).into(holder.image)

        val title = holder.title.text.toString()
        holder.itemView.setOnClickListener { Toast.makeText(mContext, "Clicked:$title", Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun swapData(newData : List<RecyclerAdapterItem>) {
        data.clear()
        data.addAll(newData)

        notifyDataSetChanged()
    }
}
