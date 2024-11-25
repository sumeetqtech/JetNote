package com.compose.jetnote.data.repository

import com.compose.jetnote.data.db.NoteDatabaseDao
import com.compose.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import java.util.UUID
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note: Note) {
        noteDatabaseDao.insert(note)
    }

    suspend fun getNote(id: UUID) {
        noteDatabaseDao.getNote(id)
    }

    suspend fun delete(note: Note) {
        noteDatabaseDao.delete(note)
    }

    suspend fun deleteAll() {
        noteDatabaseDao.deleteAll()
    }

    suspend fun update(note: Note) {
        noteDatabaseDao.update(note)
    }

    fun getNotes(): Flow<List<Note>> {
        return noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
    }
}