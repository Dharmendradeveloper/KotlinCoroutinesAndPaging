package com.orientswiss.ecom.data.model

data class Market(
    val brand: String,
    val imgUrl: String,
    val localCrossedPrice: Int,
    val localPrice: Int,
    val name: String,
    val productId: Int,
    val rank: Int,
    val ratingEmoji: String
)