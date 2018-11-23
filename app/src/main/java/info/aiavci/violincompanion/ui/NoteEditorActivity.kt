package info.aiavci.violincompanion.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import info.aiavci.violincompanion.R
import kotlinx.android.synthetic.main.activity_new_note.*

/**
 * Created by ${$FULLNAME}
 * Version
 */
class NoteEditorActivity : BaseActivity() {

    private val existingNoteId: Int? by lazy {
        intent.getIntExtra(NOTE_ID, -1)
    }

    private val existingNoteTitle: String? by lazy {
        intent.getStringExtra(NOTE_TITLE)
    }

    private val existingNoteContent: String? by lazy {
        intent.getStringExtra(NOTE_CONTENT)
    }

    private var saveMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        edit_title.setText(existingNoteTitle ?: "")
        edit_content.setText(existingNoteContent ?: "")
    }

    private val isChangeMade: Boolean
        get() = edit_title.text.toString() != existingNoteTitle ||
                edit_content.text.toString() != existingNoteContent

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_menu, menu)

        saveMenuItem = menu?.findItem(R.id.action_save)
        saveMenuItem?.isEnabled = true

        menu?.findItem(R.id.action_delete)?.isEnabled = true

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_save -> {
            // Perform save
            performSave()
            true
        }

        R.id.action_delete -> {
            // Perform delete
            performDelete()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    private fun performDelete() {
        val noteIntent = Intent()

        noteIntent.apply {
            putExtra(NOTE_ID, existingNoteId)

            val noteTitle = edit_title.text.toString()
            val noteContent = edit_content.text.toString()

            putExtra(NOTE_TITLE, noteTitle)
            putExtra(NOTE_CONTENT, noteContent)
            putExtra(NOTE_IS_DELETE, true)
        }

        setResult(Activity.RESULT_OK, noteIntent)

        finish()
    }

    private fun performSave() {
        val noteIntent = Intent()

        if (!isChangeMade) {
            setResult(Activity.RESULT_CANCELED, noteIntent)
        } else {
            val noteTitle = edit_title.text.toString()
            val noteContent = edit_content.text.toString()

            noteIntent.apply {
                if (existingNoteId != -1) {
                    putExtra(NOTE_ID, existingNoteId)
                }

                putExtra(NOTE_TITLE, noteTitle)
                putExtra(NOTE_CONTENT, noteContent)
            }

            setResult(Activity.RESULT_OK, noteIntent)
        }

        finish()
    }

    companion object {
        const val NOTE_ID = "NOTE_ID"
        const val NOTE_TITLE = "NOTE_TITLE"
        const val NOTE_CONTENT = "NOTE_CONTENT"
        const val NOTE_IS_DELETE = "NOTE_IS_DELETE"
    }
}