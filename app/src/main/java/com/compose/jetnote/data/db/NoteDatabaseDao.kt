package com.compose.jetnote.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.compose.jetnote.model.Note
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface NoteDatabaseDao {

    @Query("Select * from notes")
    fun getNotes(): Flow<List<Note>>

    @Query("Select * from notes where id=:id")
    suspend fun getNote(id: UUID) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("Delete from notes")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(note: Note)
}