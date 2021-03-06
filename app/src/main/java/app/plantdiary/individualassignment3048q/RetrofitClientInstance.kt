package app.plantdiary.individualassignment3048q

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    private var retrofit:Retrofit? = null;
    private val BASE_URL = "https://datahub.io"

    val retrofitInstance : Retrofit?
        get(){
            //Has this object been created?
            if (retrofit == null) {
                // Create retrofit instance
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

}