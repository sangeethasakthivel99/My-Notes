package com.example.mynotes.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mynotes.R
import com.example.mynotes.domain.util.NoteOrder
import com.example.mynotes.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text("Filter by")
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close"
                )
            }
        }
        RadioButton(
            text = "Title",
            checked = noteOrder is NoteOrder.Title,
            onCheck = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        RadioButton(
            text = "Date",
            checked = noteOrder is NoteOrder.Date,
            onCheck = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        RadioButton(
            text = "Color",
            checked = noteOrder is NoteOrder.Color,
            onCheck = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        RadioButton(
            text = "Ascending",
            checked = noteOrder.orderType is OrderType.Ascending,
            onCheck = {
                onOrderChange(noteOrder.copy(OrderType.Ascending))
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        RadioButton(
            text = "Descending",
            checked = noteOrder.orderType is OrderType.Descending,
            onCheck = {
                onOrderChange(noteOrder.copy(OrderType.Descending))
            }
        )
    }
}