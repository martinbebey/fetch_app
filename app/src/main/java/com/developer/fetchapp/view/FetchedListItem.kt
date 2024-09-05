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
import androidx.compose.ui.res.stringResource
import com.developer.fetchapp.R
import com.developer.fetchapp.model.Item
import com.developer.fetchapp.ui.theme.ListItemBorderColour

/**
 * This controls what each item in the list will look like on the screen
 * Each item will display its list id, its name and its id
 **/
@Composable
fun FetchedListItem(
    item: Item
){
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.list_item_row_padding))
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    dimensionResource(id = R.dimen.list_item_border_stroke),
                    ListItemBorderColour
                ),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_boorder_rounded_corner_percent))
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = "${stringResource(id = R.string.list_item_lid_label)} ${item.listId}", modifier = Modifier.padding(dimensionResource(id = R.dimen.list_item_text_padding)))
        Text(text = "${stringResource(id = R.string.list_item_name_label)} ${item.name}", modifier = Modifier.padding(dimensionResource(id = R.dimen.list_item_text_padding)))
        Text(text = "${stringResource(id = R.string.list_item_id_label)} ${item.id}", modifier = Modifier.padding(dimensionResource(id = R.dimen.list_item_text_padding)))
    }
}