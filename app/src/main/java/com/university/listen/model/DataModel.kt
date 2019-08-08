package com.university.listen.model

import android.content.Context
import com.university.listen.R

class DataModel {

    companion object {

        fun dataAdapterDemo(context: Context): ArrayList<Any> {
            val list: ArrayList<Any> = ArrayList()

            list.add(context.getString(R.string.top_shareholders))
            list.add(context.getString(R.string.top_shareholders))
            list.add(context.getString(R.string.shareholding_composition_analysis))
            list.add(context.getString(R.string.top_shareholders))
            list.add(context.getString(R.string.top_shareholders))

            return list
        }


        fun secondAdapterDemo(context: Context): ArrayList<Any> {
            val list: ArrayList<Any> = ArrayList()

            list.add(context.getString(R.string.holdings))
            list.add(context.getString(R.string.company))
            list.add(context.getString(R.string.category))
            list.add(context.getString(R.string.as_on_date))
            list.add(context.getString(R.string.apply_filters))

            return list
        }
    }
}