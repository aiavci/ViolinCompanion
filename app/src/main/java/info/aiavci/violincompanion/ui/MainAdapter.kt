package info.aiavci.violincompanion.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import info.aiavci.violincompanion.R
import kotlinx.android.synthetic.main.menu_item.view.*

/**
 * Created by ${$FULLNAME}
 * Version
 */
class MainAdapter(val context: Context): BaseAdapter() {

    private val menuItemsInfos = mutableListOf<Triple<Int, String, Activity>>(
            Triple(R.drawable.music_scale, "Scales and Arpeggios", ScaleActivity()),
            Triple(R.drawable.music_note, "Tuner", ScaleActivity()),
            Triple(R.drawable.music_symbol, "Metronome", ScaleActivity())
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val menuItemView: View
        val menuItemInfo = menuItemsInfos[position]

        if (convertView == null) {

            // if it's not recycled, initialize some attributes
            menuItemView = View.inflate(context, R.layout.menu_item, null).apply {
                imageView.apply {
                    setPadding(50, 50, 50, 50)
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    adjustViewBounds = true
                    setImageResource(menuItemInfo.first)
                }
                textView.text = menuItemInfo.second

                val intent = Intent(context, menuItemInfo.third::class.java)
                setOnClickListener {
                    context.startActivity(intent)
                }
            }

        } else {
            menuItemView = convertView
        }

        return menuItemView
    }

    override fun getCount(): Int = menuItemsInfos.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L
}

