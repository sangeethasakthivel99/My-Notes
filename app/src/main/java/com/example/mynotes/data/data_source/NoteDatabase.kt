package com.example.mynotes.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynotes.domain.model.Note

@Database(version = 1, entities = [Note::class])
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "note_database"
    }
}