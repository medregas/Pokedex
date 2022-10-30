package com.example.pokedex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public PokemonDAO (Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Pokemons pokemons){
        ContentValues values = new ContentValues();
        values.put("nome", pokemons.getNome());
        values.put("elemento", pokemons.getElemento());
        values.put("genero", pokemons.getGenero());
        return banco.insert("pokemons", null, values);
    }

    public List<Pokemons> obterTodos(){
        List<Pokemons> pokemons = new ArrayList<>();
        Cursor cursor = banco.query("pokemons", new String[]{"id","nome", "elemento", "genero"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            Pokemons a = new Pokemons();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setElemento(cursor.getString(2));
            a.setGenero(cursor.getString(3));
            pokemons.add(a);

        }

        Log.d("Ola",pokemons.get(0).getElemento());

        return pokemons;
    }

}
