package liste

import API.AbilityAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons{


    companion object{
        val AbilityAPI: AbilityAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API.AbilityAPI::class.java)
    }
    
}

