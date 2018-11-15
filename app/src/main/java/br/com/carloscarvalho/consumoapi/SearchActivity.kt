package br.com.carloscarvalho.consumoapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.carloscarvalho.consumoapi.api.PokemonAPI
import br.com.carloscarvalho.consumoapi.model.Pokemon
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_search.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btSearch.setOnClickListener {
            search()
        }
    }

    private fun search(){

        val okhttp = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create()).client(okhttp)
                .build()


        val pokeAPI = retrofit.create(PokemonAPI::class.java)


        //
        pokeAPI.search(
                inputNumeroPokemon.text.toString()
        ).enqueue(object : Callback<Pokemon>{
            override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {
                Toast.makeText(
                        this@SearchActivity,
                        t?.message,
                        Toast.LENGTH_LONG)
                        .show()
            }

            override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {
                if( response?.isSuccessful == true){
                    val pokemon = response.body()

                    tvPokemon.text = pokemon?.name

                    Picasso.get()
                            .load(pokemon?.sprites?.frontDefault)
                            .placeholder(R.drawable.searching)
                            .error(R.drawable.notfound)
                            .into(ivPokemon)
                }else{
                    tvPokemon.text = getString(R.string.not_found)

                    Picasso.get()
                            .load(R.drawable.notfound)
                            .into(ivPokemon)
                }
            }
        })

    }


}
