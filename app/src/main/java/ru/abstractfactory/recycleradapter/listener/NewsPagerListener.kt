package ru.abstractfactory.recycleradapter.listener

import ru.abstractfactory.recycleradapter.data.ItemNews

interface NewsPagerListener {
    fun getItem(position: Int): ItemNews
    fun getCount(): Int
}