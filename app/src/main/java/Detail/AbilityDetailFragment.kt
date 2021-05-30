package Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import liste.Ability
import liste.Singletons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tsirava.mobile.R



class AbilityDetailFragment : Fragment() {


    private lateinit var textViewName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_ability_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callApi()

    textViewName = view.findViewById(R.id.abilityDetail)


        }
        private fun callApi() {
            val id = arguments?.getInt( "abilityId") ?: -1
            Singletons.AbilityAPI.getabilitydetail(id)
                .enqueue(object : Callback<AbilityDetailResponse> {
                    override fun onResponse(
                        call: Call<AbilityDetailResponse>,
                        response: Response<AbilityDetailResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            textViewName.text = response.body()!!.effect_entries.toString()
                        }

                    }

                    override fun onFailure(call: Call<AbilityDetailResponse>, t: Throwable) {

                    }

                })
        }
        private fun onClickedAbility(ability: Ability) {
        findNavController().navigate(R.id.AbilityDetailFragment)


    }
    }



