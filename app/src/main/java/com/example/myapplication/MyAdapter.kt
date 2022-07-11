package com.example.myapplication

import ContentActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val tvContent = view.findViewById<TextView>(R.id.tvContent)

        fun bind(listItem: ListItem, context: Context) {
            tvContent.text = listItem.content_text
            itemView.setOnClickListener() {
                Toast.makeText(context, "Pressed: ${tvContent.text}", Toast.LENGTH_LONG).show()
                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("content", tvContent.text.toString())
                }
                context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    //надо передать кол-во эл-тов в массиве
    override fun getItemCount(): Int {
        return listArrayR.size
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}