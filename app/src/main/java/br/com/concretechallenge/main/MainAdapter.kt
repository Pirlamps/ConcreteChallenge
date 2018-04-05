package br.com.concretechallenge.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.concretechallenge.R
import br.com.concretechallenge.model.Item
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(var dataSet: List<Item>? = null) : RecyclerView.Adapter<MainAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(dataSet?.get(position))
    }

    fun setData(dataSet: List<Item>?) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    inner class MainHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item?) {
            itemView.item_name_tv.text = item?.name
            itemView.item_address_tv.text = item?.description
        }
    }
}
