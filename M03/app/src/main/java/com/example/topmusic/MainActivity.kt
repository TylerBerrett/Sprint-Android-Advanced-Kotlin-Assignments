package com.example.topmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topmusic.model.*
import com.example.topmusic.model.List.popList
import com.example.topmusic.model.List.rapList
import com.example.topmusic.model.List.rockList
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    val recyclerView by lazy {
        println("this works!")
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    lateinit var listSongs: List<Songs>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.music_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    var list: Songs by Delegates.observable(Pop("","")) {
            _, _: Songs, new: Songs ->
        listSongs = when(new){
            is Pop -> popList
            is Rap -> rapList
            is Rock -> rockList
        }
        recyclerView.adapter = MusicAdapter(listSongs)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.pop -> list = Pop("title", "artist")
            R.id.rap -> list = Rap("title", "artist")
            R.id.rock -> list = Rock("title", "artist")
        }
        return super.onOptionsItemSelected(item)
    }



}
