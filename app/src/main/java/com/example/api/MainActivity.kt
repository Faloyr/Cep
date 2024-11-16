package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    /*
        Luis Gonzaga Barbosa Silva
        72201231
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etCep = findViewById<EditText>(R.id.editTextText)
        val btnCep = findViewById<Button>(R.id.button)
        btnCep.setOnClickListener{
            busca(etCep)
        }
    }

    fun busca(etCep:EditText){
        val cep = etCep.text.toString()
        if (cep.isNullOrEmpty()) {
            Toast.makeText(
                this, "Digite o CEP para fazer a consulta",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            buscarEndereco(cep)
        }
    }
    fun buscarEndereco(cep: String) {
        val retrofitClient = Retrofit.getRetrofitInstance(path = "https://viacep.com.br/")
        val endpoint = retrofitClient.create(ICep::class.java)

        endpoint.get(cep).enqueue(object : Callback<CEPModel> {
            override fun onFailure(call: Call<CEPModel>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CEPModel>, response: Response<CEPModel>) {
                val tvResultado = findViewById<TextView>(R.id.textView2)

                val cepModel = response.body()

                if (cepModel != null) {
                    tvResultado?.text = "Logradouro: ${cepModel?.logradouro} \n" +
                            "Bairro: ${cepModel?.bairro} \n" +
                            "Cidade: ${cepModel?.localidade} \n" +
                            "UF: ${cepModel?.uf}"
                } else {
                    Toast.makeText(
                        baseContext,
                        "Não foi encontrado um endereço pra esse CEP",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}