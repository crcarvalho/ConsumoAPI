package br.com.carloscarvalho.consumoapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista.*
import java.io.LineNumberReader

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.activity_lista)

        //dentro do listOF vai o retorno JSON de um array de pokemons ou podemos inserir pokemons na lista
        rvPokemons.adapter = ListaAdapter(listOf(), this, {})
        rvPokemons.layoutManager = LinearLayoutManager(this)
    }
}
