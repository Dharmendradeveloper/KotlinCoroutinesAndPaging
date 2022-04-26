package com.orientswiss.ecom.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orientswiss.ecom.data.model.Item
import com.orientswiss.ecom.data.model.banner.Banner
import com.orientswiss.ecom.data.retrofitapiandservices.RetrofitAPIService
import com.orientswiss.ecom.data.retrofitapiandservices.RetrofitCall
import com.orientswiss.ecom.util.NetworkInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BannerRepository {
    fun getBannerRepository(context: Context): LiveData<Banner> {
        // Creating the MutableLive data object and post the entire value through it
        val mutableLiveData = MutableLiveData<Banner>()
        // Checking Internet connection if Connection is available then API gets call
        // else it will show the Toast i.e No connection is available
        if (NetworkInfo.checkForInternet(context)) {
            // Call the API service if connection is available
            // onResponse successful we get the response and post in mutable livedata
            val requestService = RetrofitCall.buildService(RetrofitAPIService::class.java)
            requestService.getAllBannerList("UZ").enqueue(object : Callback<Banner> {
                override fun onResponse(call: Call<Banner>, response: Response<Banner>) {
                    if (response.isSuccessful)
                        mutableLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<Banner>, t: Throwable) {
                    // Showing Toast message if things not work correctly
                    Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.e("Repository", t.localizedMessage)
                }
            })
        }else
            Toast.makeText(context,"Check Network Connection!", Toast.LENGTH_SHORT).show()
        return mutableLiveData
    }
}