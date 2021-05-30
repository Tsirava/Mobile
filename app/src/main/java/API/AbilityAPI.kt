package API

import retrofit2.Call
import retrofit2.http.GET

interface  AbilityAPI {


    @GET("ability")
     fun getability(): Call<AbilityResponse>
}
