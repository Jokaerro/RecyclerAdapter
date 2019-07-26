package ru.abstractfactory.recycleradapter.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import ru.abstractfactory.recycleradapter.R
import ru.abstractfactory.recycleradapter.data.ItemNews


class NewsPageFragment : Fragment() {
    companion object {
        const val KEY_NEWS = "KEY_NEWS"

        fun newInstance(itemNews: ItemNews): NewsPageFragment {
            val fragment = NewsPageFragment()
            val argument = Bundle()
            argument.putSerializable(KEY_NEWS, itemNews)
            fragment.arguments = argument
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news_item, container, false)

        val description: TextView = view.findViewById(R.id.description)
        val image: ImageView = view.findViewById(R.id.imageNews)

        arguments?.getSerializable(KEY_NEWS)?.let{ data ->
            val item = data as? ItemNews
            description.text = item?.description

            Picasso.get().load(item?.imageUrl).into(image)
        }

        return  view
    }
}