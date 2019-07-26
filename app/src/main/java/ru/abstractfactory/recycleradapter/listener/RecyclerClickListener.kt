package ru.abstractfactory.recycleradapter.listener

import android.widget.ImageView
import ru.abstractfactory.recycleradapter.data.ItemNews

interface RecyclerClickListener {
    fun onItemClick(item: ItemNews, sharedImageView: ImageView, position: Int)
}