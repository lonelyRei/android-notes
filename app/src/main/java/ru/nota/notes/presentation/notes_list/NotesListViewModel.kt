package ru.nota.notes.presentation.notes_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import ru.nota.notes.data.Note
import ru.nota.notes.data.NoteRepository
import ru.nota.notes.data.entityToNote

class NotesListViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    private val _notesLiveData = MutableLiveData<List<Note>>()
    val notesLiveData: LiveData<List<Note>> = _notesLiveData

    fun getNotes() {
        viewModelScope.launch {
            loadNotes()
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            noteRepository.deleteNote(id)
        }
    }

    private suspend fun loadNotes() {
        val notes = mutableListOf<Note>()
        val notesCallback = noteRepository.getNotes()
        notesCallback.collect { noteEntities ->
            notes.clear()
            noteEntities.forEach { noteEntity ->
                notes.add(entityToNote(noteEntity))
            }
            _notesLiveData.postValue(notes)
        }
    }
}