package com.sebastian.marketarv2.feature_products.domain.model

data class Product(

    val category: String,
    val createdAt: String,
    val delta: Double,
    val image: String,
    val minUnit: Double,
    val price: Int,
    val productName: String,
    val unit: String,
    val updatedAt: String

)

//ESTA EXCEPCION LA USA PARA HACER VALIDACIONES EN UN POST EN CLEANARCHITECTUREAPP
class InvalidProductException(message: String): Exception(message)