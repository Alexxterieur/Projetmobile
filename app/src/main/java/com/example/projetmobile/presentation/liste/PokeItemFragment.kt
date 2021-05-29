package com.example.projetmobile.presentation.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
class PokeItemFragment : Fragment() {

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
            layoutManager = this@PokeItemFragment.layout
            adapter = this@PokeItemFragment.adapterPokeItem
        }

        val list: List<PokeItem> = getListFromCache()
        if(list.isEmpty()){
            callApi()
        }else{
            showList(list)
        }
    }

    private fun getListFromCache(): List<PokeItem> {
        return emptyList()
    }

    private fun callApi() {
        Singleton.pokeItemApi.getPokeItem().enqueue(object : Callback<PokeItemResponse> {
            override fun onResponse(
                call: Call<PokeItemResponse>,
                response: Response<PokeItemResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val pokeItemResponse: PokeItemResponse = response.body()!!
                    showList(pokeItemResponse.results)
                }
            }

            override fun onFailure(call: Call<PokeItemResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun showList(pokeItemResponse: List<PokeItem>) {
        adapterPokeItem.updateList(pokeItemResponse)
    }

    private fun OnClickedPokeItem(id:Int) {
        findNavController().navigate(R.id.navigateToPokeItemDetailsFragment, bundleOf("pokeitem_id" to id+1))
    }
}

