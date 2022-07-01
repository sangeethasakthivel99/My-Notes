package com.example.mynotes.data.repository

import com.example.mynotes.data.data_source.NoteDao
import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun getNotesById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}