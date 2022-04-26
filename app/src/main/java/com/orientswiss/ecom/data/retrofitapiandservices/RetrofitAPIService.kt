package com.orientswiss.ecom.data.retrofitapiandservices



import com.orientswiss.ecom.data.model.Item
import com.orientswiss.ecom.data.model.banner.Banner
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitAPIService {
    @GET("/productlist")
     fun getAllItem(@Query("page") page:Int,
                   @Query("productTagId") productTagId:Int=13,
                   @Query("marketCode") marketCode:String="UZ"):Response<Item>
    @GET("/productlist")
     fun getAllItemList(@Query("page") page:Int,
                   @Query("productTagId") productTagId:Int=13,
                   @Query("marketCode") marketCode:String="UZ"):Call<Item>

     @GET("/home")
     fun getAllBannerList(@Query("marketCode") marketCode:String="UZ"):Call<Banner>
//    http://qvr9g.mocklab.io/productlist?page=100&productTagId=13&marketCode=UZ
}