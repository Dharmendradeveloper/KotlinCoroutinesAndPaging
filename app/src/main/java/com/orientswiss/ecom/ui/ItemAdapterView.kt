package com.orientswiss.ecom.ui
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.orientswiss.ecom.R
import com.orientswiss.ecom.data.model.Market
import com.orientswiss.ecom.data.model.RequiredItemList
import com.orientswiss.ecom.databinding.ItemAdapterBinding

class ItemAdapterView constructor(val mutableList: List<Market>, val context: Context): RecyclerView.Adapter<ItemAdapterView.ItemHolder>(){
    private lateinit var binding: ItemAdapterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        // Binding the layout through data binding concept to show user interface
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
         binding = DataBindingUtil.inflate<ItemAdapterBinding>(inflater,
            R.layout.item_adapter,parent,false)
        return ItemHolder(binding)
    }
    // To hold the data through holder class we can use OnBindViewHolder
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val data : Market = mutableList[position]//data!![position]
        // Show OR Hide feedback of item based on Value provided
        if(data.rank==0){
            binding.star.visibility = View.GONE
            binding.zeroStar.visibility = View.VISIBLE
        }else{
            binding.star.visibility = View.VISIBLE
            binding.zeroStar.visibility = View.GONE
        }
        // Creating Instance of @RequiredItemList and pass the required fields.
        val reqData:RequiredItemList = RequiredItemList(data.brand,data.imgUrl,""+data.localCrossedPrice,
            ""+data.localPrice,data.name,""+data.productId,""+data.rank
        )
        // set the data implicitly using data binding concept
        holder.binding.item = reqData//Bind data to the model data var
    }
    // To count the size of the List of Item available
    override fun getItemCount(): Int {
        return mutableList.size//data!!.size
    }

    class ItemHolder(val binding: ItemAdapterBinding): RecyclerView.ViewHolder(binding.root){

    }
}