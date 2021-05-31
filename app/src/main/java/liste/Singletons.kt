package liste

import API.AbilityAPI
import liste.AbilityApplication.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singletons{


    companion object{
        var cache = Cache( File(context?.cacheDir, "responses"), 10 * 1024 * 1024)

        val okHttpClient : OkHttpClient = OkHttpClient().newBuilder()
            .build()
        val AbilityAPI: AbilityAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(API.AbilityAPI::class.java)



    }
    
}

