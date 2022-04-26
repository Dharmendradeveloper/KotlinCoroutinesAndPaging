package com.orientswiss.ecom.data.model.banner

data class Data(
    val brandZoneBanner: List<BrandZoneBanner>,
    val mainBanner: List<MainBanner>,
    val promotionalBanner: List<PromotionalBanner>,
    val promotionalBanner2: List<PromotionalBanner2>,
    val recommended: Recommended
)