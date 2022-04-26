package com.orientswiss.ecom.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.orientswiss.ecom.data.model.banner.Banner
import com.orientswiss.ecom.data.repository.BannerRepository


class BannerViewModel:ViewModel() {
    fun getBannerFromRepo(context: Context): LiveData<Banner> {
        return BannerRepository().getBannerRepository(context)
    }
}