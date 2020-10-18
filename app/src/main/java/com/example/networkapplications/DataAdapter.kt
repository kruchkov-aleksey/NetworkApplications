package com.example.networkapplications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapplications.entity.Fact
import kotlinx.android.synthetic.main.message_list_green.view.*
import kotlinx.android.synthetic.main.message_list_orange.view.*
import kotlinx.android.synthetic.main.message_list_orange.view.name

class DataAdapter(val facts: List<Fact>, var listener: RecyclerViewClickListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var TYPE_ORANGE: Int = 2
    private var TYPE_GREEN: Int = 1

    inner class OrangeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setOrangeView(get: Fact?) {
            itemView.name.text = get?.type
            itemView.text_orange?.text = get?.text
            itemView.setOnClickListener { listener.onClick(facts, adapterPosition) }
        }
    }

    inner class GreenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setGreenViewHolder(get: Fact?) {
            itemView.name.text = get?.type
            itemView.text_green?.text = get?.text
            itemView.setOnClickListener { listener.onClick(facts, adapterPosition)  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == TYPE_ORANGE) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.message_list_orange, parent, false)
            OrangeViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.message_list_green, parent, false)
            GreenViewHolder(view)
        }
    }

    interface RecyclerViewClickListener {
        fun onClick(facts: List<Fact>?, position: Int)
    }

    override fun getItemViewType(position: Int): Int {
        return if (facts[position].text?.length!! > 60) {
                TYPE_GREEN
            } else {
                TYPE_ORANGE
            }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_ORANGE) {
            (holder as  OrangeViewHolder).setOrangeView(facts[position])
        }else{
            (holder as GreenViewHolder).setGreenViewHolder(facts[position])
        }
    }

    override fun getItemCount(): Int {
        return facts.size
    }
}