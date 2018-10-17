package info.aiavci.violincompanion.data

import android.app.Application
import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync

/**
 * Created by ${$FULLNAME}
 * Version
 */
class NoteRepository(application: Application) {

    private var noteDao: NoteDao
    var allNotes: LiveData<List<Note>>

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        noteDao = db.noteDao()

        allNotes = noteDao.getAllNotes()
    }

    fun getAllWords(): LiveData<List<Note>> {
        return allNotes
    }

    fun update (note: Note) {
        doAsync {
            noteDao.update(note)
        }
    }

   fun insert (note: Note) {
        doAsync {
            noteDao.insert(note)
        }
    }
}