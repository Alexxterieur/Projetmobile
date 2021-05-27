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
class PokemonFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var adapterPokemon = PokemonAdapter(listOf())
    private var layout = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.pokemon_recycler)
        recyclerView.apply {
            layoutManager = this@PokemonFragment.layout
            adapter = this@PokemonFragment.adapterPokemon
        }
        val pokemonList:ArrayList<Pokemon> = arrayListOf<Pokemon>().apply {
            add(Pokemon("Pikachu"))
            add(Pokemon("bulbizarre"))
            add(Pokemon("ptiplouf"))
            add(Pokemon("dialga"))
        }
        adapterPokemon.updateList(pokemonList)
    }
}