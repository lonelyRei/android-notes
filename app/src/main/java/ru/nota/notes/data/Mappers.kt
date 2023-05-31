package ru.nota.notes.data

import ru.nota.notes.data.db.NoteEntity

fun noteToEntity(note: Note) = NoteEntity(0, title = note.title, text = note.text)

fun entityToNote(noteEntity: NoteEntity) =
    Note(id = noteEntity.id, title = noteEntity.title, text = noteEntity.text, 0)