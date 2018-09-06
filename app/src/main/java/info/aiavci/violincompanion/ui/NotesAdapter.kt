package info.aiavci.violincompanion.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import info.aiavci.violincompanion.R
import info.aiavci.violincompanion.data.Note
import kotlinx.android.synthetic.main.note_item.view.*
import org.jetbrains.anko.layoutInflater
import java.util.*

/**
 * Created by ${$FULLNAME}
 * Version
 */
class NotesAdapter(val context: Context): BaseAdapter() {

    var notesList: List<Note>? = listOf()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val menuItemView: View

        // if it's not recycled, initialize some attributes
        menuItemView = LinearLayout(context).apply {
            addView(context.layoutInflater.inflate(R.layout.note_item, null).apply {
                note_title.text = notesList?.get(position)?.name ?: ""
                note_text.text = notesList?.get(position)?.name ?: ""
                note_date.text = Date().toString()
            })
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