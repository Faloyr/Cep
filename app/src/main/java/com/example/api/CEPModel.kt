package com.example.api

import com.google.gson.annotations.SerializedName

class CEPModel {
    @SerializedName( value = "cep")
    var Cep: String = "";

    @SerializedName( value = "logradouro")
    var logradouro: String = "";

    @SerializedName( value = "complemento")
    var complemento: String = "";

    @SerializedName( value = "bairro")
    var bairro: String = "";

    @SerializedName( value = "localidade")
    var localidade: String = "";

    @SerializedName( value = "uf")
    var uf: String = "";

    @SerializedName( value = "ibge")
    var ibge: String = "";

    @SerializedName( value = "ddd")
    var ddd: String = "";
}