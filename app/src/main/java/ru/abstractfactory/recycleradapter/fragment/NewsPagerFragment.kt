package ru.abstractfactory.recycleradapter.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.transition.TransitionInflater
import ru.abstractfactory.recycleradapter.MainActivity
import ru.abstractfactory.recycleradapter.adapter.NewsPagerAdapter
import ru.abstractfactory.recycleradapter.listener.NewsPagerListener
import ru.abstractfactory.recycleradapter.R
import ru.abstractfactory.recycleradapter.data.ItemNews


class NewsPagerFragment : Fragment() {

    companion object {
        const val TAG = "NewsPagerFragment"
        const val EXTRA_CURRENT_ITEM = "EXTRA_CURRENT_ITEM"

        fun newInstance(currentItem: Int): Fragment {
            val newsPageFragment = NewsPagerFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_CURRENT_ITEM, currentItem)
            newsPageFragment.arguments = bundle
            return newsPageFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        }
        sharedElementReturnTransition = null
    }

    private lateinit var pager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news_view_pager, container, false)
        pager = view.findViewById(R.id.pager)


        pager.adapter = NewsPagerAdapter(childFragmentManager, object : NewsPagerListener {
            override fun getItem(position: Int): ItemNews {
                return (activity as MainActivity).data[position]
            }

            override fun getCount(): Int {
                return (activity as MainActivity).data.size
            }

        })

        val currentItem = arguments?.getInt(EXTRA_CURRENT_ITEM) ?: 0
        pager.currentItem = currentItem

        pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                MainActivity.currentPosition = position
            }
        })

        if (savedInstanceState == null) {
            postponeEnterTransition()
        }

        return view
    }
}