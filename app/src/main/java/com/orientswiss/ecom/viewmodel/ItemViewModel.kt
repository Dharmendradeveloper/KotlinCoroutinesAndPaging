package com.orientswiss.ecom.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.orientswiss.ecom.data.model.Item
import com.orientswiss.ecom.data.repository.ItemRepository

class ItemViewModel : ViewModel() {

    fun getItemFromRepo(context: Context): LiveData<Item> {
        return ItemRepository().getItemRepository(context)
    }
}