package com.example.pokedex;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pokedex extends AppCompatActivity {

    private EditText nome;
    private EditText elemento;
    private EditText genero;
    private PokemonDAO dao;

    private Button bt_segunda_tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        nome = findViewById(R.id.edit_nome);
        elemento = findViewById(R.id.edit_tipo);
        genero = findViewById(R.id.edit_genero);
        dao = new PokemonDAO(this);

        bt_segunda_tela = findViewById(R.id.bt_segunda_tela);

        bt_segunda_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pokedex.this,ListarPokemonsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void salvar(View view){
        Pokemons a = new Pokemons();
        a.setNome(nome.getText().toString());
        a.setElemento(elemento.getText().toString());
        a.setGenero(genero.getText().toString());
        long id = dao.inserir(a);
        Toast.makeText( this, "Pokemon inserido com id " + id, Toast.LENGTH_SHORT) .show();

    }

}