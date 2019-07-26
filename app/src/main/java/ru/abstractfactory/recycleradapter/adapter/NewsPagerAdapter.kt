package ru.abstractfactory.recycleradapter.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ru.abstractfactory.recycleradapter.fragment.NewsPageFragment
import ru.abstractfactory.recycleradapter.listener.NewsPagerListener

class NewsPagerAdapter(fm: FragmentManager, private val newsPagerListener: NewsPagerListener)
    : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return NewsPageFragment.newInstance(newsPagerListener.getItem(position))
    }

    override fun getCount(): Int {
        return newsPagerListener.getCount()
    }
}