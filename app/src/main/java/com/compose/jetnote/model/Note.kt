package com.compose.jetnote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime
import java.util.UUID

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String = "",
    @ColumnInfo(name = "note_content")
    val content: String = "",
    @ColumnInfo(name = "note_entry_date")
    val entryDate: LocalDateTime = LocalDateTime.now()
)
