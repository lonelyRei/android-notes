package ru.nota.notes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import ru.nota.notes.presentation.note_edit.NoteEditViewModel
import ru.nota.notes.presentation.notes_list.NotesListViewModel

// View модели
val uiModule = module {
    viewModel {
        NoteEditViewModel(get())
    }

    viewModel {
        NotesListViewModel(get())
    }
}