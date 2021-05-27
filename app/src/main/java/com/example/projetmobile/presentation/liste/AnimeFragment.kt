package com.example.projetmobile.presentation.liste

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var adapterAnime = AnimeAdapter(listOf())
    private var layout = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.anime_recycler)
        recyclerView.apply {
            layoutManager = this@AnimeFragment.layout
            adapter = this@AnimeFragment.adapterAnime
        }
        val animeList:ArrayList<Anime> = arrayListOf<Anime>().apply {
            add(Anime("Pikachu"))
            add(Anime("bulbizarre"))
            add(Anime("ptiplouf"))
            add(Anime("dialga"))
        }
        adapterAnime.updateList(animeList)
    }
}