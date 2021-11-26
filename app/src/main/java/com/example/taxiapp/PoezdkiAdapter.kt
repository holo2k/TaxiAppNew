package com.example.taxiapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PoezdkiAdapter(val context:Context, val list:ArrayList<data_feelings>):
    RecyclerView.Adapter<PoezdkiAdapter.MyVH>()
{
    class MyVH(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imagePoezdka)
        val textView1: TextView = itemView.findViewById(R.id.tvFrom)
        val textView2: TextView = itemView.findViewById(R.id.tvWhere)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoezdkiAdapter.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.poezdki_adapter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: PoezdkiAdapter.MyVH, position: Int) {
        Glide.with(context).load(list[position].image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}