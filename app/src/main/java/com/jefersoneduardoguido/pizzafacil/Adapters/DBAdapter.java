package com.jefersoneduardoguido.pizzafacil.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by Jeferson Eduardo on 03/10/2017.
 */

public class DBAdapter {
	private SQLiteDatabase database;
	private DBHelper dbHelper;
	private String[] allColumns = {DBHelper.ID, DBHelper.NOME, DBHelper.EMAIL, DBHelper.TELEFONE, DBHelper.FOTO};

	public DBAdapter(Context context) {
		dbHelper = new DBHelper(context);
	}

	// Dá permissão de escrita no banco
	public void open() throws SQLiteException{
		database = dbHelper.getWritableDatabase();
	}

	// Fecha o banco de dados
	public void close(){
		dbHelper.close();
	}

	// Método que devolve o contato por um cursor
	private Contato cursorToContato(Cursor cursor){

		// Utiliza o cursor para fazer a captura da imagem
		byte[] blob = cursor.getBlob(cursor.getColumnIndex(DBHelper.FOTO));

		// Captura o tamanho da imagem e cria o bitmap dela
		Bitmap bmp = BitmapFactory.decodeByteArray(blob, 0 ,blob.length);

		// Faz a captura do contato como se fosse um array utilizando o cursor
		Contato contato = new Contato(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), bmp);

		// Retorna o contato
		return contato;
	}

	// Método para criar um novo contato
	public Contato createContato (String name, String email, String telefone, Bitmap foto){

		// Faz a captura dos dados do contato
		ContentValues values = new ContentValues();
		values.put(dbHelper.NOME, name);
		values.put(dbHelper.EMAIL, email);
		values.put(dbHelper.TELEFONE, telefone);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		foto.compress(Bitmap.CompressFormat.PNG, 100, baos); // Comprime a imagem como PNG
		byte[] photo = baos.toByteArray(); // Captura a imagem
		values.put(dbHelper.FOTO, photo); // Adiciona a foto no contato
		long insertId = database.insert(dbHelper.TABLE_NAME, null, values); // ID do item
		Cursor cursor = database.query(dbHelper.TABLE_NAME, allColumns,dbHelper.ID + " = " + insertId, null, null, null, null);
		cursor.moveToFirst();
		return cursorToContato(cursor); // Retorna o contato
	}

	// Elimina o contato selecionado
	public void eliminarContato(int idContato){
		database.delete(DBHelper.TABLE_NAME, DBHelper.ID + " = " + idContato, null);
	}

	// Retorna todos os contatos
	public Cursor getContatos(){
		Cursor cursor = database.rawQuery("select _id, nome, telefone, foto from contatos2", null);
		return cursor;
	}

	// Faz a captura do contato selecionado pelo ID
	public Contato getContato (int idContato){
		Cursor cursor = database.query(dbHelper.TABLE_NAME, allColumns, dbHelper.ID + " = " + idContato, null, null, null, null);
		cursor.moveToFirst();
		return cursorToContato(cursor);
	}

}
