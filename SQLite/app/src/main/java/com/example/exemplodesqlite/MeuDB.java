package com.example.exemplodesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MeuDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "meudb";
    public static final int DATABASE_VERSION = 1;
    public static final String TB_CLIENTE = "cliente";

    public MeuDB(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TB_CLIENTE (" +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " nome TEXT NOT NULL," +
                " email TEXT NOT NULL UNIQUE" +
                ")";

        db.execSQL(sql);
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void inserir(Cliente cliente){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome",cliente.getNome());
        cv.put("email",cliente.getEmail());
        db.insert(TB_CLIENTE,null,cv);
    }

    public void atualizar(Cliente cliente){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome",cliente.getNome());
        cv.put("email",cliente.getEmail());
        db.update(TB_CLIENTE,cv,"id = ?",new String[]{String.valueOf(cliente.getId())});
    }


    public void excuir (int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TB_CLIENTE,"id=?",new String[]{String.valueOf(id)});
    }


}
