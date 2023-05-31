package ru.nota.notes.presentation.note_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import ru.nota.notes.data.Note
import ru.nota.notes.data.NoteRepository
import ru.nota.notes.data.db.NoteEntity

class NoteEditViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun updateNote(note: NoteEntity) {
        noteRepository.update(note)
    }
}