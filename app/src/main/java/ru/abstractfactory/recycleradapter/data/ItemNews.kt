package ru.abstractfactory.recycleradapter.data

import java.io.Serializable


data class ItemNews(
        val title: String,
        val imageUrl: String,
        val description: String) : Serializable
