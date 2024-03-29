package liste

import API.AbilityAPI
import API.AbilityResponse
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tsirava.mobile.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AbilityFirstFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AbilityAdapter(listOf(), ::onClickedAbility)




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cocktail_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.cokctail_recyclerview)


        recyclerView.apply {
            layoutManager = LinearLayoutManager (context)
            adapter = this@AbilityFirstFragment.adapter

        }




        Singletons.AbilityAPI.getability().enqueue(object: Callback<AbilityResponse>{
            override fun onResponse(
                call: Call<AbilityResponse>, response: Response<AbilityResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val AbilityResponse = response.body()
                    if (AbilityResponse != null) {
                        adapter.updateList(AbilityResponse.results)
                    }
                }
            }

            override fun onFailure(call: Call<AbilityResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        }

        )




        }
    private fun onClickedAbility(id: Int) {
        findNavController().navigate(R.id.AbilityDetailFragment, bundleOf(
            "abilityId" to (id+1)
        ))

    }



    }

