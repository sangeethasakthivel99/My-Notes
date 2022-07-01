package com.example.mynotes.presentation.notes

import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreEvent: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
