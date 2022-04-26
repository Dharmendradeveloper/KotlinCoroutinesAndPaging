package com.orientswiss.ecom.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.slider.Slider

import com.orientswiss.ecom.R
import com.orientswiss.ecom.data.model.banner.*
import com.orientswiss.ecom.databinding.ActivityMainBinding
import com.orientswiss.ecom.ui.adapter.AutoScrollAdapter
import com.orientswiss.ecom.viewmodel.BannerViewModel
import com.orientswiss.ecom.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<AutoScrollItemURL>()
    private var cycle:Int = 0
    private var index:Int = 0
    val imageList = ArrayList<SlideModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        fetchPosts()
        // Creating the object for viewmodel and call the method to observe the data
        // using let checking if data is not empty then the control goes inside let and execute the entire body
        // of let and at begining show shimmer effect and after the data has been loaded it stop and show the
        // recyclerview
        val viewMode = ViewModelProvider(this).get(ItemViewModel::class.java)
        viewMode.getItemFromRepo(this).observe(this, Observer {
            it.let {
                binding.recycler.adapter = ItemAdapterView(it.Data.marketList,this)
//                binding.shimmerEffect.startShimmerAnimation()
//                binding.shimmerEffect.visibility = View.GONE
                binding.recycler.visibility = View.VISIBLE


            }
        })
        hideDefaultToolbarTitle()
        setCarousalViewModel()
    }

    private fun setCarousalViewModel(){
        val viewMode = ViewModelProvider(this).get(BannerViewModel::class.java)
        viewMode.getBannerFromRepo(this).observe(this,{
            addMainBannerToAdapter(it.Data.mainBanner)
            addBrandZoneBannerToAdapter(it.Data.brandZoneBanner)
            addPromotionalBannerToAdapter(it.Data.promotionalBanner)
            addPromotionalBanner2ToAdapter(it.Data.promotionalBanner2)
            binding.viewpager2.adapter = AutoScrollAdapter(list)
            binding.image.setImageList(imageList)
            println("size of list is"+list.size)
            autoScroll()
        })
    }

    private fun addPromotionalBanner2ToAdapter(promotionalBanner2: List<PromotionalBanner2>) {
        val size = promotionalBanner2.size-1
        for (i in 0..size){
            list.add(AutoScrollItemURL(promotionalBanner2[i].imageUrl))
            imageList.add(SlideModel(promotionalBanner2[i].imageUrl))
        }
    }

    private fun addPromotionalBannerToAdapter(promotionalBanner: List<PromotionalBanner>) {
        val size = promotionalBanner.size-1
        for (i in 0..size){
            list.add(AutoScrollItemURL(promotionalBanner[i].imageUrl))
            imageList.add(SlideModel(promotionalBanner[i].imageUrl))
        }
    }

    private fun addBrandZoneBannerToAdapter(brandZoneBanner: List<BrandZoneBanner>) {
        val size = brandZoneBanner.size-1
        for (i in 0..size){
            list.add(AutoScrollItemURL(brandZoneBanner[i].imageUrl))
            imageList.add(SlideModel(brandZoneBanner[i].imageUrl))
        }
    }

    private fun addMainBannerToAdapter(mainBanner: List<MainBanner>) {
        val size = mainBanner.size-1
        for (i in 0..size){
            list.add(AutoScrollItemURL(mainBanner[i].imageUrl))
            imageList.add(SlideModel(mainBanner[i].imageUrl))
        }
    }

    private fun autoScroll(){
       while (index<list.size-1){
           if(cycle%2==0){
               if(index==list.size-1){
                   cycle++
                   doWorkInBackground(index)
//                   binding.viewpager2.scrollToPosition(index)
                   index--
               }else{
//                   binding.viewpager2.scrollToPosition(index)
                   index++
               }
           }else{
               if(index==0){
                   cycle++
                   doWorkInBackground(index)
//                   binding.viewpager2.scrollToPosition(index)
                   index++
               }else{
                   doWorkInBackground(index)
//                   binding.viewpager2.scrollToPosition(index)
                   index--
               }
           }
       }
    }

    fun doWorkInBackground(index:Int){
        Handler().postDelayed({
         binding.recycler.scrollToPosition(index)
        },3000)
    }

    private fun hideDefaultToolbarTitle() {
        // Set toolbar
//        setSupportActionBar(binding.toolbar)
        // To hide the title of toolbar
        binding.toolbar.let {
//            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.hide()
        }
    }


}