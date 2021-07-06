package com.example.topmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topmusic.model.Songs
import kotlinx.android.synthetic.main.card_view.view.*

class MusicAdapter(val list: List<Songs>): RecyclerView.Adapter<MusicAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.artist.text = list[position].artist
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title = view.tv_card_title
        val artist = view.tv_card_artist
    }
}