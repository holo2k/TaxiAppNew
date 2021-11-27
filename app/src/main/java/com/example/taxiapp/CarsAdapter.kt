package com.example.taxiapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class CarsAdapter(val context: Context, val list:ArrayList<data_cars>):
    RecyclerView.Adapter<CarsAdapter.MyVH>() {
    class MyVH(ListOfView: View): RecyclerView.ViewHolder(ListOfView)
    {
        val TextView1 :TextView = itemView.findViewById(R.id.carText)
        val ImageView1 : ImageView = itemView.findViewById(R.id.carImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsAdapter.MyVH
    {
        val root = LayoutInflater.from(context).inflate(R.layout.carsadapter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: CarsAdapter.MyVH, position: Int)
    {
       holder.TextView1.text = list[position].title
        holder.ImageView1.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int
    {
       return list.size
    }

}