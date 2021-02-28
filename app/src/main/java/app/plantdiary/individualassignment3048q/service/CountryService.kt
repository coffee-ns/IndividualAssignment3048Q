package app.plantdiary.individualassignment3048q.service

import androidx.lifecycle.MutableLiveData
import app.plantdiary.individualassignment3048q.RetrofitClientInstance
import app.plantdiary.individualassignment3048q.dao.ICountryDAO
import app.plantdiary.individualassignment3048q.dto.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CountryService {

    fun fetchCountries(name: String) : MutableLiveData<ArrayList<Country>>{

        var _countries = MutableLiveData<ArrayList<Country>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(ICountryDAO::class.java)
        val call = service?.getAllCountries()
        call?.enqueue(object: Callback<ArrayList<Country>> {
            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                val j = 1 + 1
                val i = 1 + 1
            }

            override fun onResponse(
                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                _countries.value = response.body()
            }

        })

        return _countries

    }

}