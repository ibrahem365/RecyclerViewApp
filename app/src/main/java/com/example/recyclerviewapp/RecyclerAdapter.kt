package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var title = arrayOf("CH1","CH2","CH3","CH4","CH5","CH6","CH7")
    private var detail = arrayOf("CH1 details","CH2 details","CH3 details","CH4 details","CH5 details"
        ,"CH6 details","CH7 details")
    private var images = arrayOf(R.drawable.ic_baseline_ondemand_video_24,R.drawable.ic_baseline_ondemand_video_24,
        R.drawable.ic_baseline_ondemand_video_24,R.drawable.ic_baseline_ondemand_video_24,R.drawable.ic_baseline_ondemand_video_24,
        R.drawable.ic_baseline_ondemand_video_24,R.drawable.ic_baseline_ondemand_video_24)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        //fill data in view
        holder.itemTitle.text = title[position]
        holder.itemDetail.text= detail[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage : ImageView
        var itemTitle : TextView
        var itemDetail : TextView
        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener{
                val position:Int =adapterPosition

                Toast.makeText(itemView.context,"you clicked in ${title[position]}",Toast.LENGTH_SHORT).show()
            }
        }
    }

}