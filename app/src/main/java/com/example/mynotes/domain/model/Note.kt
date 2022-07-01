package com.example.mynotes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynotes.ui.theme.*
import java.lang.Exception

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(blue, red, yellow, neonGreen, pink)
    }
}

class InvalidNoteException(message: String): Exception(message)