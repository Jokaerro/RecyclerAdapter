package ru.abstractfactory.recycleradapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import ru.abstractfactory.recycleradapter.*
import ru.abstractfactory.recycleradapter.adapter.RecyclerAdapter
import ru.abstractfactory.recycleradapter.listener.RecyclerClickListener
import ru.abstractfactory.recycleradapter.data.ItemNews


class NewsFragment : Fragment() {

    companion object{
        const val TAG = "NewsFragment"

    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val pageView = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = pageView.findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        val llm = GridLayoutManager(context, 2)
        recyclerView.layoutManager = llm
        val adapter = RecyclerAdapter(object : RecyclerClickListener {
            override fun onItemClick(item: ItemNews, sharedImageView: ImageView, position: Int) {
                MainActivity.currentPosition = position

                val animalDetailFragment = NewsPagerFragment.newInstance(MainActivity.currentPosition)
                fragmentManager?.apply {
                    beginTransaction()
                            .addSharedElement(sharedImageView, ViewCompat.getTransitionName(sharedImageView)
                                    ?: "")
                            .addToBackStack(TAG)
                            .add(R.id.container, animalDetailFragment)
                            .commit()
                }
            }

        }, (activity as MainActivity).data)
        recyclerView.adapter = adapter

        return pageView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollToPosition()
    }

    private fun scrollToPosition() {
        recyclerView.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(v: View,
                                        left: Int,
                                        top: Int,
                                        right: Int,
                                        bottom: Int,
                                        oldLeft: Int,
                                        oldTop: Int,
                                        oldRight: Int,
                                        oldBottom: Int) {
                recyclerView.removeOnLayoutChangeListener(this)
                val layoutManager = recyclerView.layoutManager
                val viewAtPosition = layoutManager?.findViewByPosition(MainActivity.currentPosition)
                if (viewAtPosition == null || layoutManager
                                .isViewPartiallyVisible(viewAtPosition, false, true)) {
                    recyclerView.post { layoutManager?.scrollToPosition(MainActivity.currentPosition) }
                }
            }
        })
    }
}