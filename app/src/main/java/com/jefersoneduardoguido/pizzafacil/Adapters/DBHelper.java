package com.jefersoneduardoguido.pizzafacil.Adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jefer on 25/09/2017.
 *
 * Classe do banco de dados
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "contatos.db";
    public static final String TABLE_NAME = "contatos2";
    private static final int DATABASE_VERSION = 1;
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";
    public static final String FOTO = "foto";
    public static final String DATABASE_CREATE = "create table" + TABLE_NAME + "( " + ID + " integer primary key autoincrement, "
            + NOME + " text not null, " + EMAIL + " text not null, " + TELEFONE + " text not null, " + NOME + " BLOB);";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Cria o banco de dados
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    // Faz a atualização do banco de dados
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.w(DBHelper.class.getName(), "Updating database from version " + i + " to " + i1 + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // função que permite ler no banco de dados
    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    // função que permite escrever no banco de dados
    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }


}
