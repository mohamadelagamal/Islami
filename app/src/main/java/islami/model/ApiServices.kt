package islami.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    //.. add baseUrl to this function and set text after base URL
    @GET("radio_ar.json")
    fun getRadiosDataFromApi() : Call<Response>
}