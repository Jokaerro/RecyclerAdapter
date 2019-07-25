package ru.abstractfactory.recycleradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    var data: ArrayList<RecyclerAdapterItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()

        recyclerView.setHasFixedSize(true)
        val llm = LinearLayoutManager(this)
        recyclerView.layoutManager = llm
        val adapter = RecyclerAdapter(this, data)
        recyclerView.adapter = adapter
    }

    private fun initList() {
        data.add(RecyclerAdapterItem(
                resources.getStringArray(R.array.news1)[0],
                resources.getStringArray(R.array.news1)[1],
                resources.getStringArray(R.array.news1)[2]))
        data.add(RecyclerAdapterItem(
                resources.getStringArray(R.array.news2)[0],
                resources.getStringArray(R.array.news2)[1],
                resources.getStringArray(R.array.news2)[2]))
        data.add(RecyclerAdapterItem(
                resources.getStringArray(R.array.news3)[0],
                resources.getStringArray(R.array.news3)[1],
                resources.getStringArray(R.array.news3)[2]))
        data.add(RecyclerAdapterItem(
                resources.getStringArray(R.array.news4)[0],
                resources.getStringArray(R.array.news4)[1],
                resources.getStringArray(R.array.news4)[2]))
        data.add(RecyclerAdapterItem(
                resources.getStringArray(R.array.news5)[0],
                resources.getStringArray(R.array.news5)[1],
                resources.getStringArray(R.array.news5)[2]))
        data.add(RecyclerAdapterItem(
                resources.getStringArray(R.array.news6)[0],
                resources.getStringArray(R.array.news6)[1],
                resources.getStringArray(R.array.news6)[2]))
    }
}
