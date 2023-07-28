package com.example.flowapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class DataAdapter(val list : List<DataModel>):RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txtData = itemView.findViewById<TextView>(R.id.txtView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
      return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.data_view,parent,false))

    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val data = list[position]
        holder.txtData.setText(data.name)




    }
}