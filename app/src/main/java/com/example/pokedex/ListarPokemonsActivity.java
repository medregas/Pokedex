package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarPokemonsActivity extends AppCompatActivity {

    private ListView listView;
    private PokemonDAO dao;
    private List<Pokemons> pokemons;
    private List<Pokemons> pokemonsFiltrados = new ArrayList<>();

    private Button bt_primeira_tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pokemons);

        listView = findViewById(R.id.lista_pokemons);
        dao = new PokemonDAO(this);
        pokemons = dao.obterTodos();
        pokemonsFiltrados.addAll(pokemons);
        ArrayAdapter<Pokemons> adaptador = new ArrayAdapter<Pokemons>(this, android.R.layout.simple_list_item_1, pokemons);
        listView.setAdapter(adaptador);

        bt_primeira_tela = findViewById(R.id.bt_primeira_tela);

        bt_primeira_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarPokemonsActivity.this,Pokedex.class);
                startActivity(intent);
            }
        });

    }
}