package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarBancoDados();
    }

    public void criarBancoDados(){
        bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pokedex(nome VARCHAR, elemento VARCHAR, genero VARCHAR)");
        bancoDados.execSQL("INSERT INTO pokedex(nome,elemento,genero) VALUES('Rattata', 'Comum', 'Masculino')");
    }
}