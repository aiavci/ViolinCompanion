package info.aiavci.violincompanion.ui

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import info.aiavci.violincompanion.R
import info.aiavci.violincompanion.data.Note
import kotlinx.android.synthetic.main.activity_notes.*
import org.jetbrains.anko.intentFor

/**
 * Created by ${$FULLNAME}
 * Version
 */
class NotesActivity: BaseActivity() {

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProviders.of(this).get(NoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        listView.adapter = NotesAdapter(this).apply {
            notesList = noteViewModel.allNotes.value
        }

        fab.setOnClickListener {
            startActivityForResult(intentFor<NoteEditorActivity>(), 1)
        }

        noteViewModel.allNotes.observe(this, Observer<List<Note>> { notes ->
            // Update the cached copy of the Notes in the adapter.
            (listView.adapter as NotesAdapter).setNotes(notes)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (
                data != null &&
                requestCode == 1 &&
                resultCode == Activity.RESULT_OK
        ) {

            val noteId = data.getIntExtra(NoteEditorActivity.NOTE_ID, -1)

            val noteTitle = data.getStringExtra(NoteEditorActivity.NOTE_TITLE)
            val noteContent = data.getStringExtra(NoteEditorActivity.NOTE_CONTENT)

            val noteToSave: Note
            if (noteId != -1) {
                noteToSave = Note(
                    noteTitle,
                    noteContent,
                    noteId
                )

                noteViewModel.update(noteToSave)


            } else {
                noteToSave = Note(
                    noteTitle,
                    noteContent
                )

                noteViewModel.insert(noteToSave)
            }
        } else {
            Toast.makeText(
                    applicationContext,
                    R.string.no_change_made,
                    Toast.LENGTH_LONG).show()
        }

    }
}