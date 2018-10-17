package info.aiavci.violincompanion.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import info.aiavci.violincompanion.data.Note
import info.aiavci.violincompanion.data.NoteRepository

/**
 * Created by ${$FULLNAME}
 * Version
 */
class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository: NoteRepository by lazy {
        NoteRepository(application)
    }

    var allNotes: LiveData<List<Note>> = noteRepository.getAllWords()

    fun insert(note: Note) {
        noteRepository.insert(note)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }
}