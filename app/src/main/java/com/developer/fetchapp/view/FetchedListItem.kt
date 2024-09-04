package com.developer.fetchapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.developer.fetchapp.R
import com.developer.fetchapp.model.Item
import com.developer.fetchapp.ui.theme.ListItemBorderColour

@Composable
fun FetchedListItem(
    item: Item
){
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.list_item_row_padding))
            .fillMaxWidth()
            .border(
                border = BorderStroke(dimensionResource(id = R.dimen.list_item_border_stroke) , ListItemBorderColour),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_boorder_rounded_corner_percent))
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = "LId: ${item.listId}", modifier = Modifier.padding(dimensionResource(id = R.dimen.list_item_text_padding)))
        Text(text = "Name: ${item.name}", modifier = Modifier.padding(dimensionResource(id = R.dimen.list_item_text_padding)))
        Text(text = "ID: ${item.id}", modifier = Modifier.padding(dimensionResource(id = R.dimen.list_item_text_padding)))
    }
}