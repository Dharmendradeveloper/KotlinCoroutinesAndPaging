package com.orientswiss.ecom.util

import androidx.recyclerview.widget.DiffUtil
import com.orientswiss.ecom.data.model.Market

class DiffUtilCallBack : DiffUtil.ItemCallback<Market>() {
    override fun areItemsTheSame(oldItem: Market, newItem: Market): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Market, newItem: Market): Boolean {
        return oldItem.productId == newItem.productId
//                && oldItem.score == newItem.score
//                && oldItem.commentCount == newItem.commentCount
    }
}