package ru.nota.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

import ru.nota.notes.data.db.dao.NoteDao

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}