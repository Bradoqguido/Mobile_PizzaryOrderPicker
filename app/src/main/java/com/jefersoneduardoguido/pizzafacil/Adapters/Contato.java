package com.jefersoneduardoguido.pizzafacil.Adapters;

import android.graphics.Bitmap;

/**
 * Created by Jeferson Eduardo on 03/10/2017.
 */

public class Contato {

    private long _id;
    private String nome;
    private String email;
    private String telefone;
    private Bitmap foto;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Contato(long _id, String nome, String email, String telefone) {
        this._id = _id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Contato(long _id, String nome, String email, String telefone, Bitmap foto) {
        this._id = _id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

}
