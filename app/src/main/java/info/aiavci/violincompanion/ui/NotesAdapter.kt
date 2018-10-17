package info.aiavci.violincompanion.ui

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import info.aiavci.violincompanion.R
import info.aiavci.violincompanion.data.Note
import info.aiavci.violincompanion.ui.NoteEditorActivity.Companion.NOTE_CONTENT
import info.aiavci.violincompanion.ui.NoteEditorActivity.Companion.NOTE_ID
import info.aiavci.violincompanion.ui.NoteEditorActivity.Companion.NOTE_TITLE
import kotlinx.android.synthetic.main.note_item.view.*
import org.jetbrains.anko.intentFor
import java.util.*

/**
 * Created by ${$FULLNAME}
 * Version
 */
class NotesAdapter(val activity: Activity): BaseAdapter() {

    var notesList: List<Note>? = listOf()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val menuItemView: View

        // if it's not recycled, initialize some attributes
        menuItemView = LinearLayout(activity).apply {
            addView(activity.layoutInflater.inflate(R.layout.note_item, null).apply {
                note_title.text = notesList?.get(position)?.noteTitle ?: ""
                note_text.text = notesList?.get(position)?.noteContent ?: ""
                note_date.text = Date().toString()
            })

            setOnClickListener {
                val noteId: Int = notesList?.get(position)?.id ?: return@setOnClickListener
                val noteTitle: String = notesList?.get(position)?.noteTitle ?: ""
                val noteContent: String = notesList?.get(position)?.noteContent ?: ""

                val editIntent = activity.intentFor<NoteEditorActivity>(
                        NOTE_ID to noteId,
                        NOTE_TITLE to noteTitle,
                        NOTE_CONTENT to noteContent
                )

                activity.startActivityForResult(editIntent, 1)
            }
        }

        return menuItemView
    }

    fun setNotes(notes: List<Note>?) {
        notesList = notes
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    override fun getCount(): Int = notesList?.size ?: 0
}