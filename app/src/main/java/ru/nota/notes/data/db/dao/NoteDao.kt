package ru.nota.notes.data.db.dao

import androidx.room.*

import kotlinx.coroutines.flow.Flow

import ru.nota.notes.data.db.NoteEntity

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteEntity: NoteEntity)

    @Query("SELECT * FROM NoteEntity")
    fun getAll(): Flow<List<NoteEntity>>

    @Update
    suspend fun update(Note: NoteEntity)

    @Query("DELETE FROM NoteEntity WHERE id = :idToDelete")
    suspend fun delete(idToDelete: Int)
}