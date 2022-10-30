package com.example.pokedex;

import java.io.Serializable;

public class Pokemons implements Serializable {

    private Integer id;
    private String nome;
    private String elemento;
    private String genero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
   @Override
    public String toString(){

        return String.format("%s\n\t%s\t%s\n", nome,elemento,genero);

    }

}

