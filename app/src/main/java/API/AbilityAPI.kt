package API

import Detail.AbilityDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  AbilityAPI {


    @GET("ability")
     fun getability(): Call<AbilityResponse>


    @GET("ability/{id}")
    fun getabilitydetail(@Path("id") id : Int): Call<AbilityDetailResponse>
}
