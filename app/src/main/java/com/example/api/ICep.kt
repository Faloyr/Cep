package com.example.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ICep {

    @GET(value = "/ws/{cep}/json/")
    fun get(@Path(value = "cep") cep: String): Call<CEPModel>


}