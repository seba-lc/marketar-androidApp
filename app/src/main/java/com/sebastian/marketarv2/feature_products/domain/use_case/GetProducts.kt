package com.sebastian.marketarv2.feature_products.domain.use_case

import com.sebastian.marketarv2.core.data.repository.MarketRepositoryImpl
import com.sebastian.marketarv2.feature_products.domain.model.Product
import com.sebastian.marketarv2.feature_products.domain.model.util.OrderType
import com.sebastian.marketarv2.feature_products.domain.model.util.ProductOrder
import javax.inject.Inject

class GetProducts @Inject constructor(
    private val repository: MarketRepositoryImpl
) {

    suspend operator fun invoke(
        productOrder: ProductOrder = ProductOrder.All(OrderType.Descending),
        category: String?
    ) : List<Product> {

        var result: List<Product> = emptyList()
        var filteredList = ArrayList<Product>()
        //LE TENGO DUDAS A QUE FUNCIONE ESTO DE FILTRAR POR CATEGORIA PERO VEREMOS

        when(productOrder.orderType) {
            is OrderType.Ascending -> {
                result = when(productOrder) {
                    is ProductOrder.All -> repository.getProducts().sortedBy { it.productName }
                    is ProductOrder.Category -> {
                        repository.getProducts().forEach { product ->
                            if(product.category == category) {
                                filteredList.add(product)
                            }
                        }
                        filteredList.sortedBy { it.productName }
                    }
                }
            }
            is OrderType.Descending -> {
                result = when(productOrder) {
                    is ProductOrder.All -> repository.getProducts().sortedByDescending { it.productName }
                    is ProductOrder.Category -> {
                        repository.getProducts().forEach { product ->
                            if(product.category == category) {
                                filteredList.add(product)
                            }
                        }
                        filteredList.sortedByDescending { it.productName }
                    }
                }
            }
        }

        return result

    }

//    suspend operator fun invoke() : List<Product> {
//        return repository.getProducts().sortedBy { it.productName }
//    }

}