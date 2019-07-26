package ru.abstractfactory.recycleradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.abstractfactory.recycleradapter.data.ItemNews
import ru.abstractfactory.recycleradapter.fragment.NewsFragment
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    companion object {
        var currentPosition = 0
        const val KEY_CURRENT_POSITION = "KEY_CURRENT_POSITION"
    }

    var data: ArrayList<ItemNews> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(KEY_CURRENT_POSITION, 0)
            return
        }
        val fragmentManager = supportFragmentManager
        fragmentManager
                .beginTransaction()
                .add(R.id.container, NewsFragment(), NewsFragment.TAG)
                .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CURRENT_POSITION, currentPosition)
    }

    private fun initList() {
        data.add(ItemNews(
                resources.getStringArray(R.array.news1)[0],
                resources.getStringArray(R.array.news1)[1],
                resources.getStringArray(R.array.news1)[2]))
        data.add(ItemNews(
                resources.getStringArray(R.array.news2)[0],
                resources.getStringArray(R.array.news2)[1],
                resources.getStringArray(R.array.news2)[2]))
        data.add(ItemNews(
                resources.getStringArray(R.array.news3)[0],
                resources.getStringArray(R.array.news3)[1],
                resources.getStringArray(R.array.news3)[2]))
        data.add(ItemNews(
                resources.getStringArray(R.array.news4)[0],
                resources.getStringArray(R.array.news4)[1],
                resources.getStringArray(R.array.news4)[2]))
        data.add(ItemNews(
                resources.getStringArray(R.array.news5)[0],
                resources.getStringArray(R.array.news5)[1],
                resources.getStringArray(R.array.news5)[2]))
        data.add(ItemNews(
                resources.getStringArray(R.array.news6)[0],
                resources.getStringArray(R.array.news6)[1],
                resources.getStringArray(R.array.news6)[2]))
    }
}
