package ru.abstractfactory.recycleradapter.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.squareup.picasso.Picasso
import ru.abstractfactory.recycleradapter.R
import ru.abstractfactory.recycleradapter.data.ItemNews
import ru.abstractfactory.recycleradapter.listener.RecyclerClickListener


class RecyclerAdapter(
        private val clickListener: RecyclerClickListener,
        private var data: ArrayList<ItemNews>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_adapter_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = data[position].title

        Picasso.get().load(data[position].imageUrl).into(holder.image)

        ViewCompat.setTransitionName(holder.image, position.toString())
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(data[position], holder.image, position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun swapData(newData : List<ItemNews>) {
        data.clear()
        data.addAll(newData)

        notifyDataSetChanged()
    }
}
