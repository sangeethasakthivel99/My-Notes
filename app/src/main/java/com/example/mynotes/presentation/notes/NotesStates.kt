package com.example.mynotes.presentation.notes

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.util.NoteOrder
import com.example.mynotes.domain.util.OrderType

data class NotesStates(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)