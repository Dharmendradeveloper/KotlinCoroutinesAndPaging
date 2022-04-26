package com.orientswiss.ecom.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.orientswiss.ecom.R
import com.orientswiss.ecom.data.model.banner.AutoScrollItemURL
import com.orientswiss.ecom.databinding.AutoScrollLayoutBinding

class AutoScrollAdapter constructor(val list:List<AutoScrollItemURL>): RecyclerView.Adapter<AutoScrollAdapter.AutoViewHolder>() {
    private lateinit var autoScrollLayoutBinding: AutoScrollLayoutBinding
    private var cycle:Int=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoViewHolder {
        autoScrollLayoutBinding = DataBindingUtil.inflate<AutoScrollLayoutBinding>(
            LayoutInflater.from(parent.context), R.layout.auto_scroll_layout,
        parent,false)
        return AutoViewHolder(autoScrollLayoutBinding)
    }

    override fun onBindViewHolder(holder: AutoViewHolder, position: Int) {
        autoScrollLayoutBinding.item = list[position]


    }



    override fun getItemCount(): Int {
        return list.size
    }
    inner class AutoViewHolder(itemView: AutoScrollLayoutBinding) :RecyclerView.ViewHolder(itemView.root){

    }
}