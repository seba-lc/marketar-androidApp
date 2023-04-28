package com.sebastian.marketarv2.feature_cart.domain.use_case

data class CartUseCases(
    val addProduct: AddProduct,
    val deleteProduct: DeleteProduct,
    val getProducts: GetProducts,
    val substractProduct: SubstractProduct,
    val deleteCart: DeleteCart
)
