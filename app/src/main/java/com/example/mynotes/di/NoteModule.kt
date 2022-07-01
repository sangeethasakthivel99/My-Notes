package com.example.mynotes.di

import android.app.Application
import androidx.room.Room
import com.example.mynotes.data.data_source.NoteDao
import com.example.mynotes.data.data_source.NoteDatabase
import com.example.mynotes.data.repository.NoteRepositoryImpl
import com.example.mynotes.domain.repository.NoteRepository
import com.example.mynotes.domain.usecase.AddNoteUseCase
import com.example.mynotes.domain.usecase.DeleteNoteUseCase
import com.example.mynotes.domain.usecase.GetNotesUseCase
import com.example.mynotes.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(context: Application): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository)
        )
    }
}