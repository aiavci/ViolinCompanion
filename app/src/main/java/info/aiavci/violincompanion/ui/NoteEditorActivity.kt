package info.aiavci.violincompanion.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        edit_title.setText(existingNoteTitle ?: "")
        edit_content.setText(existingNoteContent ?: "")

        button_save.setOnClickListener {
            performSave()
        }
    }

    private fun performSave() {
        val noteIntent = Intent()

        if (TextUtils.isEmpty(edit_content.text)) {
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
    }
}