package com.rfonzi.jotbubble

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rfonzi.libraries.model.Bubble

class BubbleRecyclerViewAdapter : RecyclerView.Adapter<BubbleViewHolder>() {

    private val bubbles = mutableListOf<Bubble>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BubbleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bubble, parent, false)

        return BubbleViewHolder(view)
    }

    override fun getItemCount(): Int = bubbles.size

    override fun onBindViewHolder(holder: BubbleViewHolder, position: Int) {
        val bubble = bubbles[position]
        holder.bubbleId.text = "${bubble.id}"
        holder.bubbleContent.text = bubble.contents
    }

    fun addBubbles(bubbleList: List<Bubble>) {
        bubbles.addAll(bubbleList)
        notifyDataSetChanged()
    }
}

class BubbleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bubbleId: TextView = itemView.findViewById(R.id.bubble_id)
    val bubbleContent: TextView = itemView.findViewById(R.id.bubble_content)
}