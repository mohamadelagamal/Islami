package islami.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//.. to build retrofit
class ApiManager {
    //... now we use Singleton pattern to use this object in all application
    companion object{
      private  var retrofit:Retrofit?=null
      private  fun getRetrofitInstance():Retrofit{
            if (retrofit==null){
                //....make untit
                 retrofit = Retrofit.Builder()
                    .baseUrl(Constants.RadioApi_Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        // now we build retrofit and interface we must use both in this function
        //... this function return object (Singleton pattern) by make access about (ApiServices and function getRetrofitInstance)
        fun getApi():ApiServices{
            return getRetrofitInstance().create(ApiServices::class.java)
        }
    }

}