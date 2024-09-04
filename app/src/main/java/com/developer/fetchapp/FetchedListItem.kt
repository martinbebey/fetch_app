package com.developer.fetchapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FetchedListItem(
    item: Item
){
    Row(
        modifier = Modifier.
        padding(8.dp).
        fillMaxWidth().
        border(
            border = BorderStroke(2.dp, Color(0xFFFFAD45)),
            shape = RoundedCornerShape(20)
        )
    ){

    }
}