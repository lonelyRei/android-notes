package ru.nota.notes.di

import androidx.room.Room

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

import ru.nota.notes.data.NoteRepository
import ru.nota.notes.data.db.AppDatabase

// Модуль базы данных
val dbModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "notes"
        ).fallbackToDestructiveMigration().build()
    }

    single {
        get<AppDatabase>().getNoteDao()
    }

    single {
        NoteRepository(get())
    }
}