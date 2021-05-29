package com.example.projetmobile.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.projetmobile.R
import com.example.projetmobile.presentation.Singleton
import com.example.projetmobile.presentation.api.PokeItemDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PokeItemDetailsFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokeitem_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName=view.findViewById(R.id.pokeitem_details_name)
        var idcmpt: Int = 1
        while (idcmpt<=20) {
            makeApiCall(idcmpt)
            idcmpt++
        }
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.navigateToPokeItemFragment)
        }
    }

    private fun makeApiCall(idcmpt: Int) {
        Singleton.pokeItemApi.getPokeItemDetails(idcmpt.toString()).enqueue(object : Callback<PokeItemDetailsResponse>{
            override fun onResponse(
                call: Call<PokeItemDetailsResponse>,
                response: Response<PokeItemDetailsResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text= response.body()!!.name
                }

            }

            override fun onFailure(call: Call<PokeItemDetailsResponse>, t: Throwable) {

            }

        })
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<PokeItemDetailsResponse>) {

}


