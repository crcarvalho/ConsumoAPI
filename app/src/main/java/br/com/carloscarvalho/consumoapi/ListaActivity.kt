package br.com.carloscarvalho.consumoapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.carloscarvalho.consumoapi.model.Pokemon
import br.com.carloscarvalho.consumoapi.model.Sprites
import kotlinx.android.synthetic.main.activity_lista.*
import java.io.LineNumberReader

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        //dentro do listOF vai o retorno JSON de um array de pokemons ou podemos inserir pokemons na lista
        rvPokemons.adapter = ListaAdapter(listOf(Pokemon("Charmander",
                Sprites("https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png")),
                Pokemon("Squirtle",
                        Sprites("https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png")),
                Pokemon("Bulbassaur",
                        Sprites("https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"))), this, {})
        rvPokemons.layoutManager = LinearLayoutManager(this)
    }
}
