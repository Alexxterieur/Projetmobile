package com.example.projetmobile.presentation.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R
import com.example.projetmobile.presentation.Singleton
import com.example.projetmobile.presentation.api.PokeItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var adapterPokeItem = PokeItemAdapter(listOf(), ::OnClickedPokeItem)



    private var layout = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokeitem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.pokeitem_recycler)
        recyclerView.apply {
            layoutManager = this@AnimeFragment.layout
            adapter = this@AnimeFragment.adapterPokeItem
        }

        Singleton.pokeItemApi.getPokeItem().enqueue(object: Callback<PokeItemResponse>{
            override fun onResponse(call: Call<PokeItemResponse>, response: Response<PokeItemResponse>) {
                if(response.isSuccessful && response.body() !=null){
                    val PokeItemResponse: PokeItemResponse= response.body()!!
                    adapterPokeItem.updateList(PokeItemResponse.results)
                }
            }

            override fun onFailure(call: Call<PokeItemResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        /*val animeList:ArrayList<Anime> = arrayListOf<Anime>().apply {
            add(Anime("Pikachu"))
            add(Anime("bulbizarre"))
            add(Anime("ptiplouf"))
            add(Anime("dialga"))
        }
        adapterAnime.updateList(animeList)*/
    }
    private fun OnClickedPokeItem() {
        findNavController().navigate(R.id.navigateToPokeItemDetailsFragment)
    }
}

