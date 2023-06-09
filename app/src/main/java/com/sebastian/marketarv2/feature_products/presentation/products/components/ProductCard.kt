package com.sebastian.marketarv2.feature_products.presentation.products.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sebastian.marketarv2.feature_products.domain.model.Product

@Composable
fun ProductCard(item: Product) {

    val painter = rememberImagePainter(
        data = "https://storage.googleapis.com/marketar_bucket/" + item.image,
        builder = {
            crossfade(true)
        }
    )

    Card(
        modifier = Modifier
//            .padding(15.dp)
            .fillMaxWidth()
            .height(200.dp)
            .padding(12.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)

            ) {
                Image(
                    painter = painter,
                    contentDescription = item.productName,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)

            ) {

                Text(text = item.productName, style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center))
                Text(text = "$${item.price}/${item.unit}", style = TextStyle(fontSize = 20.sp))

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .border(BorderStroke(1.dp, Color.Black))
                            .clickable {
                                //TODO
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "-", style = TextStyle(fontSize = 20.sp))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .border(BorderStroke(1.dp, Color.Black)),
                        contentAlignment = Alignment.Center

                    ) {
                        //ACA IRA EL ESTADO QUE IRA ARMANDO EL CARRITO
                        Text(text = "0", style = TextStyle(fontSize = 20.sp))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .border(BorderStroke(1.dp, Color.Black))
                            .clickable {
                                //TODO
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "+", style = TextStyle(fontSize = 20.sp))
                    }
                }
            }

        }

    }

}