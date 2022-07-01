package com.example.mynotes.domain.usecase

import com.example.mynotes.domain.model.InvalidNoteException
import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NoteRepository

class AddNoteUseCase(val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("Title of the note can't be empty")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("Content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}